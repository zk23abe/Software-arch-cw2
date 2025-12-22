package Model;

import java.util.Date;

public class Specialist extends Clinician {
    public Specialist(String specialistId, String specialistName, Date dob, boolean isNurse , String specialty) {
        super (specialistId,specialistName,dob,isNurse);
        this.specialty=specialty;
    }
    public void viewReferral(Referral referral) {
        if (referral != null) {
            System.out.println("Model.Referral ID: " + referral.getRefId());
            System.out.println("Patient: " + referral.getPatient());
            System.out.println("Referred By: " + referral.getReferrer());
            System.out.println("Target Model.Specialist: " + referral.getReferredSpecialist());

        } else {
            System.out.println("invalid referral");
        }
    }


    private String specialty;

}
