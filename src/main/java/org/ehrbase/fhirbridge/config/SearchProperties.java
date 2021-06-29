package org.ehrbase.fhirbridge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fhir-bridge")
public class SearchProperties {

    private SearchMode search = SearchMode.DATABASE;

    public SearchMode getSearch() {
        return search;
    }

    public void setSearch(SearchMode search) {
        this.search = search;
    }

    public enum SearchMode {

        DATABASE, OPENEHR

    }
}
