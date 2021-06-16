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

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.fhirbridge.ehr.ResourceTemplateProvider;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * {@link Configuration} for EHRbase.
 *
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(EhrbaseProperties.class)
@Import(EhrbaseTemplateInitializer.class)
public class EhrbaseConfiguration {

    private final EhrbaseProperties properties;

    public EhrbaseConfiguration(EhrbaseProperties properties) {
        this.properties = properties;
    }

    @Bean
    public OpenEhrClientConfig restClientConfig() throws URISyntaxException {
        return new OpenEhrClientConfig(new URI(properties.getBaseUrl()));
    }

    @Bean
    public TemplateProvider templateProvider() {
        return new ResourceTemplateProvider(properties.getTemplate().getPrefix());
    }

    @Bean
    public DefaultRestClient openEhrClient(OpenEhrClientConfig restClientConfig, TemplateProvider templateProvider) {
        return new DefaultRestClient(restClientConfig, templateProvider, httpClient());
    }

    private HttpClient httpClient() {
        var builder = HttpClientBuilder.create();

        EhrbaseProperties.Security security = properties.getSecurity();
        if (security.getType() == EhrbaseProperties.AuthorizationType.BASIC) {
            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(security.getUser(), security.getPassword()));
            builder.setDefaultCredentialsProvider(credentialsProvider);
        }

        return builder.build();
    }
}
