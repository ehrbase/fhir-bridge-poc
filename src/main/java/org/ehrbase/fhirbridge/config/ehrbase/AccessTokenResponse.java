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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AccessTokenResponse model.
 */
public class AccessTokenResponse {

    private final String accessToken;

    private final long expiresIn;

    private final long refreshExpiresIn;

    private final String tokenType;

    private final String idToken;

    private final String scope;


    public AccessTokenResponse(@JsonProperty("access_token") String accessToken,
                               @JsonProperty("expires_in") long expiresIn,
                               @JsonProperty("refresh_expires_in") long refreshExpiresIn,
                               @JsonProperty("token_type") String tokenType,
                               @JsonProperty("id_token") String idToken,
                               @JsonProperty("scope") String scope) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.refreshExpiresIn = refreshExpiresIn;
        this.idToken = idToken;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public long getRefreshExpiresIn() {
        return refreshExpiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getIdToken() {
        return idToken;
    }

    public String getScope() {
        return scope;
    }
}
