package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.DvIdentifier;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.729695700+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
@OptionFor("DV_IDENTIFIER")
public class ProAnalytZugehoerigeLaborprobeDvIdentifier implements RMEntity, ProAnalytZugehoerigeLaborprobeChoice {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Zugehörige Laborprobe/Zugehörige Laborprobe
   * Description: Kennung der Probe, die für das Analyseergebnis verwendet wurde.
   */
  @Path("")
  private DvIdentifier zugehoerigeLaborprobe;

  public void setZugehoerigeLaborprobe(DvIdentifier zugehoerigeLaborprobe) {
     this.zugehoerigeLaborprobe = zugehoerigeLaborprobe;
  }

  public DvIdentifier getZugehoerigeLaborprobe() {
     return this.zugehoerigeLaborprobe ;
  }
}
