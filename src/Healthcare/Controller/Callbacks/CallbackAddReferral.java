package Healthcare.Controller.Callbacks;

import Healthcare.Utility.Result;

public interface CallbackAddReferral {
    Result<String, String> addReferral(String patientId, String referrerId, String specialistId);
}