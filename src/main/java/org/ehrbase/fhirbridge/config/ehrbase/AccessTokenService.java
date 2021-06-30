/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.fhirbridge.config.ehrbase;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Service that handles requesting OAuth2 access token to the configured authorization server.
 *
 * @since 1.2.0
 */
@SuppressWarnings("java:S6212")
public class AccessTokenService {

    private final WebClient webClient;

    private final String clientId;

    private final String clientSecret;

    private String token;

    private Instant expirationTime;

    public AccessTokenService(String tokenUrl, String clientId, String clientSecret) {
        webClient = WebClient.builder().baseUrl(tokenUrl).build();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getToken() {
        if (token == null || isTokenExpired()) {
            token = requestAccessToken();
        }
        return token;
    }

    private String requestAccessToken() {
        Instant requestTime = Instant.now();

        AccessTokenResponse response = webClient.post()
                .body(BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret))
                .retrieve()
                .bodyToMono(AccessTokenResponse.class)
                .blockOptional()
                .orElseThrow(() -> new IllegalArgumentException("Response must not be null"));

        // Set token expiration time
        expirationTime = requestTime.plus(response.getExpiresIn(), ChronoUnit.SECONDS);

        return response.getAccessToken();
    }

    private boolean isTokenExpired() {
        return Instant.now().isAfter(expirationTime);
    }
}
