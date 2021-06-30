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

import org.apache.xmlbeans.XmlOptions;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.ehr.ResourceTemplateProvider;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.namespace.QName;
import java.util.Optional;

/**
 * {@link InitializingBean} used to trigger template initialization in the remote EHRbase instance.
 *
 * @since 1.0.0
 */
@SuppressWarnings("java:S6212")
public class EhrbaseTemplateInitializer implements InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(EhrbaseTemplateInitializer.class);

    private final EhrbaseProperties properties;

    private final ResourceTemplateProvider templateProvider;

    private final OpenEhrClient openEhrClient;

    private final AccessTokenService accessTokenService;

    private final WebClient webClient;

    public EhrbaseTemplateInitializer(EhrbaseProperties properties, ResourceTemplateProvider templateProvider, OpenEhrClient openEhrClient, AccessTokenService accessTokenService) {
        this.properties = properties;
        this.templateProvider = templateProvider;
        this.openEhrClient = openEhrClient;
        this.accessTokenService = accessTokenService;
        this.webClient = adminWebClient();
    }

    @Override
    public void afterPropertiesSet() {
        LOG.info("Initializing templates...");

        for (String templateId : templateProvider.getTemplateIds()) {

            Optional<OPERATIONALTEMPLATE> ehrbaseTemplate = openEhrClient.templateEndpoint()
                    .findTemplate(templateId);

            if (ehrbaseTemplate.isEmpty()) {
                createTemplate(templateId);
            } else if (properties.getTemplate().isForceUpdate()) {
                updateTemplate(templateId);
            }
        }
    }

    private void createTemplate(String templateId) {
        LOG.info("Create template '{}'", templateId);
        openEhrClient.templateEndpoint().ensureExistence(templateId);
    }

    private void updateTemplate(String templateId) {
        LOG.info("Update template '{}'", templateId);
        OPERATIONALTEMPLATE fhirBridgeTemplate = templateProvider.find(templateId)
                .orElseThrow(() -> new IllegalStateException("Failed to load template with id " + templateId));

        var options = new XmlOptions();
        options.setSaveSyntheticDocumentElement(new QName("http://schemas.openehr.org/v1", "template"));

        var uri = UriComponentsBuilder.fromHttpUrl(properties.getBaseUrl())
                .path("/admin/template/{templateId}")
                .build(templateId);

        try {
            webClient.put()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_XML)
                    .bodyValue(fhirBridgeTemplate.xmlText(options))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientException e) {
            throw new IllegalStateException("An error occurred while updating the template with id " + templateId + " in EHRbase");
        }
    }

    private WebClient adminWebClient() {
        var webClientBuilder = WebClient.builder();

        var security = properties.getSecurity();
        if (security.getType() == EhrbaseProperties.AuthorizationType.BASIC) {
            EhrbaseProperties.User user = properties.getSecurity().getUser();
            webClientBuilder.filter(ExchangeFilterFunctions.basicAuthentication(user.getAdminName(), user.getAdminPassword()));
        } else if (security.getType() == EhrbaseProperties.AuthorizationType.OAUTH2) {
            webClientBuilder.filter((request, next) -> next.exchange(ClientRequest.from(request)
                    .headers(headers -> headers.setBearerAuth(accessTokenService.getToken()))
                    .build()));
        }

        return webClientBuilder.build();
    }
}
