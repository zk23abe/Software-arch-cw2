public class AdminStaff {
    public AdminStaff(String id, String fullName) {
        this.staffId = id;
        this.staffFullName = fullName;
    }

    public manageAppointment(AppointmentManager instance) {
    }

    public boolean isPatientExists(AppointmentManager appointmentManagerSinglton, String patientId) {
        for (Patient patient : appointmentManagerSinglton.getPatients()) {
            if (patient.getpatientID().equals(patientId)) {
                return true;
            }
        }
        return false;
    }

    String staffId;
    String staffFullName;
}
