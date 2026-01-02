package Healthcare.Controller.Callbacks;

import Healthcare.Utility.Result;
import java.util.Date;

public interface CallbackAddPatient {
    Result<String, String> addPatient(String firstName, String lastName,
                                      Date dob, String nhsNumber,
                                      String phone, String email, String address);
}