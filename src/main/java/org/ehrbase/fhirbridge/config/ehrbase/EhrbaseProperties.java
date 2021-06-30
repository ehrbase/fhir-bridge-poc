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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * {@link ConfigurationProperties ConfigurationProperties} to configure EHRbase.
 *
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "fhir-bridge.ehrbase")
public class EhrbaseProperties {

    private String baseUrl;

    private final Security security = new Security();

    private final Template template = new Template();

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Security getSecurity() {
        return security;
    }

    public Template getTemplate() {
        return template;
    }

    public static class Security {

        private AuthorizationType type;

        private final User user = new User();

        private final OAuth2 oAuth2 = new OAuth2();

        public AuthorizationType getType() {
            return type;
        }

        public void setType(AuthorizationType type) {
            this.type = type;
        }

        public User getUser() {
            return user;
        }

        public OAuth2 getOAuth2() {
            return oAuth2;
        }
    }

    public static class Template {

        private String prefix;

        private boolean forceUpdate;

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public boolean isForceUpdate() {
            return forceUpdate;
        }

        public void setForceUpdate(boolean forceUpdate) {
            this.forceUpdate = forceUpdate;
        }
    }

    public static class User {

        private String name;

        private String password;

        private String adminName;

        private String adminPassword;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAdminName() {
            return adminName;
        }

        public void setAdminName(String adminName) {
            this.adminName = adminName;
        }

        public String getAdminPassword() {
            return adminPassword;
        }

        public void setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
        }
    }


    public static class OAuth2 {

        private String tokenUrl;

        private String clientId;

        private String clientSecret;

        public String getTokenUrl() {
            return tokenUrl;
        }

        public void setTokenUrl(String tokenUrl) {
            this.tokenUrl = tokenUrl;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientSecret() {
            return clientSecret;
        }

        public void setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
        }
    }

    public enum AuthorizationType {

        NONE, BASIC, OAUTH2
    }
}
