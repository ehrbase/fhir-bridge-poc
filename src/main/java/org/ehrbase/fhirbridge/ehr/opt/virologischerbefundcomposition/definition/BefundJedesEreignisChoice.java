package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.745332800+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public interface BefundJedesEreignisChoice {
  NullFlavour getLabortestBezeichnungNullFlavourDefiningCode();

  void setLabortestBezeichnungNullFlavourDefiningCode(
      NullFlavour labortestBezeichnungNullFlavourDefiningCode);

  List<BefundKommentarElement> getKommentar();

  void setKommentar(List<BefundKommentarElement> kommentar);

  List<Cluster> getStrukturierteErfassungDerStoerfaktoren();

  void setStrukturierteErfassungDerStoerfaktoren(
      List<Cluster> strukturierteErfassungDerStoerfaktoren);

  ProbeCluster getProbe();

  void setProbe(ProbeCluster probe);

  DvCodedText getLabortestBezeichnung();

  void setLabortestBezeichnung(DvCodedText labortestBezeichnung);

  FeederAudit getFeederAudit();

  void setFeederAudit(FeederAudit feederAudit);

  TemporalAccessor getTimeValue();

  void setTimeValue(TemporalAccessor timeValue);

  List<Cluster> getMultimediaDarstellung();

  void setMultimediaDarstellung(List<Cluster> multimediaDarstellung);

  List<Cluster> getStrukturierteTestdiagnostik();

  void setStrukturierteTestdiagnostik(List<Cluster> strukturierteTestdiagnostik);

  LabortestPanelCluster getLabortestPanel();

  void setLabortestPanel(LabortestPanelCluster labortestPanel);
}
