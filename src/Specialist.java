import Model.Clinician;

import java.util.Date;

public class Specialist extends Clinician {
    public Specialist(String specialistId, String specialistName, Date dob, boolean isNurse , String specialty) {
        super (specialistId,specialistName,dob,isNurse);
        this.specialty=specialty;
    }
    public Referral viewReferral(String referralId) {
        for (Referral referral : this.referrals
    }


    private String specialty;

}
