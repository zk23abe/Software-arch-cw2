package Healthcare.Controller.Callbacks;

import Healthcare.Utility.Result;
import java.util.Date;

public interface CallbackAddAppointment {
    Result<String, String> addAppointment(String patientId, String clinicianId, Date date, String time);
}
