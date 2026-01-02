package Healthcare.Controller.Callbacks;

import Healthcare.Utility.Result;

public interface CallbackAddPrescription {
    Result<String, String> addPrescription(String patientId, String doctorId, String medication, String notes);
}