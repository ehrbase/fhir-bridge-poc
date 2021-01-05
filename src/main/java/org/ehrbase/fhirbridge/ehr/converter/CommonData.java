package org.ehrbase.fhirbridge.ehr.converter;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.archetyped.FeederAuditDetails;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.r4.model.DomainResource;

public class CommonData {

  public static FeederAudit constructFeederAudit(DomainResource fhirResource) {
    FeederAudit fa = new FeederAudit();

    // source system
    String sourceSystem = fhirResource.getMeta().getSource();

    if (sourceSystem == null) {
      sourceSystem = "FHIR-bridge";
    }

    FeederAuditDetails fad = new FeederAuditDetails();
    fad.setSystemId(sourceSystem);

    fa.setOriginatingSystemAudit(fad);

    // set item id
    List<DvIdentifier> ids = new ArrayList<>();

    DvIdentifier id = new DvIdentifier();
    id.setId(fhirResource.getId().toString());
    id.setType("fhir_logical_id");

    ids.add(id);
    fa.setOriginatingSystemItemIds(ids);

    // original content
    /* now the content is stored in the bridge
    FhirContext ctx = FhirContext.forR4();
    IParser parser = ctx.newJsonParser();
    String originalContent = parser.encodeResourceToString(fhirResource);

    DvParsable originalContentEnc = new DvParsable();
    originalContentEnc.setValue(originalContent);
    originalContentEnc.setFormalism("application/json");

    fa.setOriginalContent(originalContentEnc);
    */

    return fa;
  }
}
