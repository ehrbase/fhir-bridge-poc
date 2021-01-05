package org.ehrbase.fhirbridge.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.ehr.EhrStatus;
import com.nedap.archie.rm.generic.PartySelf;
import com.nedap.archie.rm.support.identification.HierObjectId;
import com.nedap.archie.rm.support.identification.PartyRef;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.fhirbridge.ehr.ResourceTemplateProvider;
import org.junit.jupiter.api.BeforeAll;

abstract class AbstractSetupIT {

  static final String PATIENT_ID_TOKEN = "\\{\\{patientId\\}\\}";

  static String PATIENT_ID;

  protected final FhirContext context;

  protected final IGenericClient client;

  public AbstractSetupIT() {
    context = FhirContext.forR4();
    context.getRestfulClientFactory().setSocketTimeout(60 * 1000);
    client = context.newRestfulGenericClient("http://localhost:8888/fhir-bridge/fhir/");
  }

  @BeforeAll
  static void setup() throws URISyntaxException {
    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(
        AuthScope.ANY, new UsernamePasswordCredentials("myuser", "myPassword432"));

    CloseableHttpClient httpClient =
        HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();

    DefaultRestClient client =
        new DefaultRestClient(
            new OpenEhrClientConfig(new URI("http://localhost:8080/ehrbase/rest/openehr/v1/")),
            new ResourceTemplateProvider("classpath:/opt/*.opt"),
            httpClient);

    PATIENT_ID = UUID.randomUUID().toString();

    EhrStatus ehrStatus = new EhrStatus();
    ehrStatus.setSubject(
        new PartySelf(new PartyRef(new HierObjectId(PATIENT_ID), "demographic", "PERSON")));
    ehrStatus.setArchetypeNodeId("openEHR-EHR-EHR_STATUS.generic.v1");
    ehrStatus.setName(new DvText("Integration tests status"));
    client.ehrEndpoint().createEhr(ehrStatus);
  }
}
