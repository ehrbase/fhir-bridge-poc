package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeDvUri;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeDvIdentifier;

import org.hl7.fhir.r4.model.Observation;

public class ProAnalytZugehoerigeLaborprobeChoiceConverter extends ProAnalytZugehoerigeLaborprobeDvIdentifier {

    public ProAnalytZugehoerigeLaborprobeChoice convertDvIdentifier(Observation observation){

        ProAnalytZugehoerigeLaborprobeDvIdentifier proAnalytZugehoerigeLaborprobeDvIdentifier = new ProAnalytZugehoerigeLaborprobeDvIdentifier();

        if(observation.getSpecimen().getIdentifier() == null){
            throw new UnprocessableEntityException("Unknown identifier");
        }

        DvIdentifier dvIdentifier = new DvIdentifier();

        dvIdentifier.setAssigner(observation.getSpecimen().getIdentifier().getAssigner().getDisplay());

        dvIdentifier.setId(observation.getSpecimen().getIdentifier().getId());

        dvIdentifier.setType(observation.getSpecimen().getIdentifier().getType().getText());

        proAnalytZugehoerigeLaborprobeDvIdentifier.setZugehoerigeLaborprobe(dvIdentifier);

        return proAnalytZugehoerigeLaborprobeDvIdentifier;

    }

    public ProAnalytZugehoerigeLaborprobeChoice convertDvUri(Observation observation){

        ProAnalytZugehoerigeLaborprobeDvUri proAnalytZugehoerigeLaborprobeDvUri = new ProAnalytZugehoerigeLaborprobeDvUri();

        proAnalytZugehoerigeLaborprobeDvUri.setZugehoerigeLaborprobeValue(observation.getSpecimen().getTypeElement());

        return proAnalytZugehoerigeLaborprobeDvUri;

    }



}
