package org.ehrbase.fhirbridge.ehr.converter.specific.d4lquestionnaire.sections.symptoms;

import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.converter.specific.d4lquestionnaire.sections.QuestionnaireSection;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.FieberInDenLetzten24StundenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.FieberInDenLetzten4TagenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.ProblemDiagnoseEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.SchweregradDefiningCode;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.SchuettelfrostInDenLetzten24StundenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.SchlappheitAngeschlagenheitCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.GliederschmerzenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.HustenInDenLetzten24StundenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.SchnupfenInDenLetzten24StundenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.DurchfallCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.GeschmacksUndOderGeruchsverlustCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.HalsschmerzenInDenLetzten24StundenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.KopfschmerzenCluster;
import org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition.AtemproblemeCluster;

import org.hl7.fhir.r4.model.QuestionnaireResponse;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Symptoms extends QuestionnaireSection {
    private static final String S0 = "S0";
    private static final String S1 = "S1";
    private static final String S2 = "S2";
    private static final String S3 = "S3";
    private static final String S4 = "S4";
    private static final String S5 = "S5";
    private static final String S6 = "S6";
    private static final String S7 = "S7";
    private static final String S8 = "S8";
    private static final String S9 = "S9";
    private static final String SA = "SA";
    private static final String SB = "SB";
    private static final String SC = "SC";
    private static final String SZ = "SZ";

    private Optional<ProblemDiagnoseEvaluation> problemDiagnoseEvaluationQuestion = Optional.empty();

    public Symptoms(Language language, TemporalAccessor startTimeValue) {
        super(language, startTimeValue);
    }

    @Override
    public void map(List<QuestionnaireResponse.QuestionnaireResponseItemComponent> item) {
        for (QuestionnaireResponse.QuestionnaireResponseItemComponent question : item) {
            if (getValueCode(question).isPresent()) {
                mapSymptomsQuestions(question);
            }
        }
    }

    private void mapSymptomsQuestions(QuestionnaireResponse.QuestionnaireResponseItemComponent question) {
        switch (question.getLinkId()) {
            case S0:
                //TODO Strategy Pattern
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapFever24h(getQuestionLoincYesNoToBoolean(question));
                break;
            case S1:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapFever4days(getQuestionLoincYesNoToBoolean(question));
                break;
            case S2:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapFeverTemperature(getQuestionValueCodeToString(question));
                break;
            case S3:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapChills(getQuestionLoincYesNoToBoolean(question));
                break;
            case S4:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapTired(getQuestionLoincYesNoToBoolean(question));
                break;
            case S5:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapBodyAches(getQuestionLoincYesNoToBoolean(question));
                break;
            case S6:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapPersistentCoughing(getQuestionLoincYesNoToBoolean(question));
                break;
            case S7:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapRhinitis(getQuestionLoincYesNoToBoolean(question));
                break;
            case S8:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapDiarrhea(getQuestionLoincYesNoToBoolean(question));
                break;
            case S9:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapSoreThroat(getQuestionLoincYesNoToBoolean(question));
                break;
            case SA:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapHeadache(getQuestionLoincYesNoToBoolean(question));
                break;
            case SB:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapProblemsWhenBreathing(getQuestionLoincYesNoToBoolean(question));
                break;
            case SC:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapTasteSmellLoss(getQuestionLoincYesNoToBoolean(question));
                break;
            case SZ:
                setProblemDiagnoseEvaluationIfNotSet(question);
                this.mapWhenSymptomsAppear(getValueAsDate(question).get());
                break;
            default:
                throw new ConversionException("LinkId " + question.getLinkId() + " undefined");
        }
    }

    private void setProblemDiagnoseEvaluationIfNotSet(QuestionnaireResponse.QuestionnaireResponseItemComponent question) {
        if (problemDiagnoseEvaluationQuestion.isEmpty()) {
            ProblemDiagnoseEvaluationConverter problemDiagnoseEvaluationConverter = new ProblemDiagnoseEvaluationConverter();
            ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationConverter.convert(question, language, authored);
            problemDiagnoseEvaluation.setDatumZeitpunktDesAuftretensDerErstdiagnoseValue(authored); //Bad code
            problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
        }

    }

    private void mapFever24h(Boolean hasFewer24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        FieberInDenLetzten24StundenCluster fieberInDenLetzten24StundenCluster = new FieberInDenLetzten24StundenCluster();
        fieberInDenLetzten24StundenCluster.setVorhandenValue(hasFewer24h);
        problemDiagnoseEvaluation.setFieberInDenLetzten24Stunden(fieberInDenLetzten24StundenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }


    private void mapFever4days(Boolean hasFewer4Days) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        FieberInDenLetzten4TagenCluster fieberInDenLetzten4TagenCluster = new FieberInDenLetzten4TagenCluster();
        fieberInDenLetzten4TagenCluster.setVorhandenValue(hasFewer4Days);
        problemDiagnoseEvaluation.setFieberInDenLetzten4Tagen(fieberInDenLetzten4TagenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapFeverTemperature(String maxFewerTemperature) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        FieberInDenLetzten4TagenCluster fieberInDenLetzten4TagenCluster = problemDiagnoseEvaluation.getFieberInDenLetzten4Tagen();
        FieberInDenLetzten24StundenCluster fieberInDenLetzten24StundenCluster = problemDiagnoseEvaluation.getFieberInDenLetzten24Stunden();
        if (fieberInDenLetzten4TagenCluster != null && fieberInDenLetzten4TagenCluster.isVorhandenValue()) {
            fieberInDenLetzten4TagenCluster.setSchweregradDefiningCode(parseStringToSchweregrad(maxFewerTemperature));
            problemDiagnoseEvaluation.setFieberInDenLetzten4Tagen(fieberInDenLetzten4TagenCluster);
        }
        if (fieberInDenLetzten24StundenCluster != null && fieberInDenLetzten24StundenCluster.isVorhandenValue()) {
            fieberInDenLetzten24StundenCluster.setSchweregradDefiningCode(parseStringToSchweregrad(maxFewerTemperature));
            problemDiagnoseEvaluation.setFieberInDenLetzten24Stunden(fieberInDenLetzten24StundenCluster);
        }
    }

    private SchweregradDefiningCode parseStringToSchweregrad(String schweregrad) {
        if (schweregrad.equals(SchweregradDefiningCode.N38_C.getCode())) {
            return SchweregradDefiningCode.N38_C;
        } else if (schweregrad.equals(SchweregradDefiningCode.N39_C.getCode())) {
            return SchweregradDefiningCode.N39_C;
        } else if (schweregrad.equals(SchweregradDefiningCode.N40_C.getCode())) {
            return SchweregradDefiningCode.N40_C;
        } else if (schweregrad.equals(SchweregradDefiningCode.N41_C.getCode())) {
            return SchweregradDefiningCode.N41_C;
        } else if (schweregrad.equals("above-42C")) {
            return SchweregradDefiningCode.N42_C;
        } else if (schweregrad.equals(SchweregradDefiningCode.ICH_WEISS_ES_NICHT.getCode())) {
            return SchweregradDefiningCode.ICH_WEISS_ES_NICHT;
        } else {
            throw new ConversionException("fewer max temperature: " + schweregrad + " is not a valid code value !");
        }
    }

    private void mapChills(Boolean hasChills24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        SchuettelfrostInDenLetzten24StundenCluster schuttelfrostInDenLetzten24StundenCluster = new SchuettelfrostInDenLetzten24StundenCluster();
        schuttelfrostInDenLetzten24StundenCluster.setVorhandenValue(hasChills24h);
        problemDiagnoseEvaluation.setSchuettelfrostInDenLetzten24Stunden(schuttelfrostInDenLetzten24StundenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);

    }

    private void mapTired(Boolean isTired) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        SchlappheitAngeschlagenheitCluster schlappheitAngeschlagenheitCluster = new SchlappheitAngeschlagenheitCluster();
        schlappheitAngeschlagenheitCluster.setVorhandenValue(isTired);
        problemDiagnoseEvaluation.setSchlappheitAngeschlagenheit(schlappheitAngeschlagenheitCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapBodyAches(Boolean hasBodyAches) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        GliederschmerzenCluster gliederschmerzenCluster = new GliederschmerzenCluster();
        gliederschmerzenCluster.setVorhandenValue(hasBodyAches);
        problemDiagnoseEvaluation.setGliederschmerzen(gliederschmerzenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapPersistentCoughing(Boolean hasPersistentCoughing24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        HustenInDenLetzten24StundenCluster hustenInDenLetzten24StundenCluster = new HustenInDenLetzten24StundenCluster();
        hustenInDenLetzten24StundenCluster.setVorhandenValue(hasPersistentCoughing24h);
        problemDiagnoseEvaluation.setHustenInDenLetzten24Stunden(hustenInDenLetzten24StundenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapRhinitis(Boolean hasRhinitis24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        SchnupfenInDenLetzten24StundenCluster schnupfenInDenLetzten24StundenCluster = new SchnupfenInDenLetzten24StundenCluster();
        schnupfenInDenLetzten24StundenCluster.setVorhandenValue(hasRhinitis24h);
        problemDiagnoseEvaluation.setSchnupfenInDenLetzten24Stunden(schnupfenInDenLetzten24StundenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);

    }

    private void mapDiarrhea(Boolean hasDiarrhea) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        DurchfallCluster durchfallCluster = new DurchfallCluster();
        durchfallCluster.setVorhandenValue(hasDiarrhea);
        problemDiagnoseEvaluation.setDurchfall(durchfallCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);

    }

    private void mapSoreThroat(Boolean hasSoreThroat24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        HalsschmerzenInDenLetzten24StundenCluster halsschmerzenInDenLetzten24StundenCluster = new HalsschmerzenInDenLetzten24StundenCluster();
        halsschmerzenInDenLetzten24StundenCluster.setVorhandenValue(hasSoreThroat24h);
        problemDiagnoseEvaluation.setHalsschmerzenInDenLetzten24Stunden(halsschmerzenInDenLetzten24StundenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapHeadache(Boolean hasHeadache24h) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        KopfschmerzenCluster kopfschmerzenCluster = new KopfschmerzenCluster();
        kopfschmerzenCluster.setVorhandenValue(hasHeadache24h);
        problemDiagnoseEvaluation.setKopfschmerzen(kopfschmerzenCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapProblemsWhenBreathing(Boolean hasProblemsBreathing) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        AtemproblemeCluster atemproblemeCluster = new AtemproblemeCluster();
        atemproblemeCluster.setVorhandenValue(hasProblemsBreathing);
        problemDiagnoseEvaluation.setAtemprobleme(atemproblemeCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapTasteSmellLoss(Boolean hasTasteSmellLoss) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        GeschmacksUndOderGeruchsverlustCluster geschmacksUndOderGeruchsverlustCluster = new GeschmacksUndOderGeruchsverlustCluster();
        geschmacksUndOderGeruchsverlustCluster.setVorhandenValue(hasTasteSmellLoss);
        problemDiagnoseEvaluation.setGeschmacksUndOderGeruchsverlust(geschmacksUndOderGeruchsverlustCluster);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    private void mapWhenSymptomsAppear(TemporalAccessor sinceWhenSymptoms) {
        ProblemDiagnoseEvaluation problemDiagnoseEvaluation = problemDiagnoseEvaluationQuestion.get();
        problemDiagnoseEvaluation.setDatumZeitpunktDesAuftretensDerErstdiagnoseValue(sinceWhenSymptoms);
        problemDiagnoseEvaluationQuestion = Optional.of(problemDiagnoseEvaluation);
    }

    public List<ProblemDiagnoseEvaluation> getProblemDiagnose() {
        List<ProblemDiagnoseEvaluation> problemDiagnoseEvaluationList = new ArrayList<>();
        problemDiagnoseEvaluationQuestion.ifPresent(problemDiagnoseEvaluationList::add);
        return problemDiagnoseEvaluationList;
    }
}