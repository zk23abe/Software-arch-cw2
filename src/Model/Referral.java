package Model;

import java.util.Date;

public class Referral {
    public Referral(String refId, Clinician referrer, Patient patient, Specialist referredSpecialist, Date date) {
        this.referredSpecialist = referredSpecialist;
        this.patient = patient;
        this.referrer = referrer;
        this.refId = refId;
    }

    public String getRefId() {
        return refId;
    }

    public Specialist getReferredSpecialist() {
        return referredSpecialist;
    }

    public Clinician getReferrer() {
        return referrer;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Model.Referral{" +
                "refId=' " + refId + '\'' +
                ", referrer= " + referrer +
                ", patient= " + patient +
                ", referredSpecialist= " + referredSpecialist +
                '}';
    }

    private String refId;
    private Clinician referrer;
    private Patient patient;
    private Specialist referredSpecialist;


}
