import java.util.Date;

public class Prescription {
    String patientid;
    String medication;
    String prescriptionId;
    String clinicianId;
    Date prescriptionDate;

    public Prescription(String patientid, String medication, String prescriptionId, String clinicianId, Date prescriptionDate) {
        this.patientid = patientid;
        this.medication = medication;
        this.prescriptionId = prescriptionId;
        this.clinicianId = clinicianId;
        this.prescriptionDate = prescriptionDate;
    }

    public String getPatientid() {
        return patientid;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getMedication() {
        return medication;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "\n patientid: '" + patientid + '\'' +
                "\n medication: '" + medication + '\'' +
                "\n prescriptionId: '" + prescriptionId + '\'' +
                "\n clinicianId: " + clinicianId + '\'' +
                "\n prescriptionDate: " + prescriptionDate +
                '}';
    }
}
