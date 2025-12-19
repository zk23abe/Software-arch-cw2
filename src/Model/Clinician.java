package Model;

import java.util.*;

public class Clinician extends Person {
    public Clinician(String clinicanId, String fullName, Date dob, boolean isNurse){
        super(clinicanId,fullName,dob);
        this.isNurse=isNurse;
    }
    public Prescription createPrescription(Patient patient, String prescriptionId, String medication, Date prescriptionDate){
        return new Prescription(patient.getpatientID(),medication,prescriptionId,this.getPersonId(),prescriptionDate);
    }
    public String getPatientRecord(Patient patient){
        return patient.getMedicalRecord();
    }

    public boolean getIsNurse(){
        return isNurse;
    }

    public void updatePatientRecord(Patient patient, String newMedicalRecord){
        patient.updateMedicalRecord(newMedicalRecord);
    }

    public void createReferral

    @Override
    public String toString() {
        return "Clinican{" +
                "isNurse=" + isNurse +
                ", personId='" + personId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                '}';
    }

    boolean isNurse;
}
