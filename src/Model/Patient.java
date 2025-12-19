package Model;

public class Patient {
    public Patient(String patientId, String medicalRecord, String patientFirstName, String patientSurname, String address) {
        this.medicalRecord = medicalRecord;
        this.patientFirstName = patientFirstName;
        this.patientSurname = patientSurname;
        this.address = address;
    }

    public String getpatientID(){
        return patientId;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void updateMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails(){
        return String.format("Model.Patient Details: \n firstname: %s\n surname: %s\n Address: %s", patientFirstName, patientSurname, address );
    }

    public String toString(){
        return String.format(" ALl Model.Patient Details: \n firstname: %s\n surname %s\n Address: %s\n Medical Record: %s", patientFirstName, patientSurname, address, medicalRecord);
    }
    private String patientId;
    private String medicalRecord;
    private String patientFirstName;
    private String patientSurname;
    private String address;


}

