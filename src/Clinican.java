import java.util.*;

public class Clinican extends Person {
    public Clinican(String clinicanId, String fullName, Date dob, boolean isNurse){
        super(clinicanId,fullName,dob);
        this.isNurse=isNurse;
    }
    public Prescription createPrescription(Patient patient, String prescriptionId, String medication, Date prescriptionDate){
        return new Prescription(patient.getpatientID(),medication,prescriptionId,this.getPersonId(),prescriptionDate);
    }



    boolean isNurse;
}
