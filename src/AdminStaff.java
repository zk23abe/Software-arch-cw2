import Healthcare.Model.AppointmentManager;
import Healthcare.Model.datatypes.Patient;

import java.util.Date;

public class AdminStaff {
    public AdminStaff(String id, String fullName) {
        this.staffId = id;
        this.staffFullName = fullName;
    }

    public void cancelAppointment(AppointmentManager instance, String apptId) {
        instance.cancelAppointment(apptId);
    }
    public void rescheduleAppointment(AppointmentManager instance, String apptId, Date date) {
        instance.rescheduleAppointment(apptId, date);

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
