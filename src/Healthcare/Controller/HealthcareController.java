package Healthcare.Controller;

import Healthcare.Controller.Callbacks.CallbackAddAppointment;
import Healthcare.Controller.Callbacks.CallbackAddPatient;
import Healthcare.Controller.Callbacks.CallbackAddPrescription;
import Healthcare.Controller.Callbacks.CallbackAddReferral;
import Healthcare.Model.AppointmentManager;
import Healthcare.View.HealthcareGUI;
import Healthcare.Utility.Result;

import java.util.Date;

public class HealthcareController {
    private final HealthcareGUI view;
    private final AppointmentManager model;

    public HealthcareController(HealthcareGUI view, AppointmentManager model) {
        this.view = view;
        this.model = model;

        // 1. Connect the GUI Listeners to our Logic
        this.view.setAddPatientListener(new AddPatientHandler());
        this.view.setAddAppointmentListener(new AddAppointmentHandler());

        // 2. Load Initial Data into the GUI
        this.view.updatePatientList(model.getPatients());
        this.view.updateAppointmentList(model.getAppointments());

        this.view.setAddReferralListener(new AddReferralHandler());
        this.view.setAddPrescriptionListener(new AddPrescriptionHandler());
        this.view.updateReferralList(model.getReferrals());
        this.view.updatePrescriptionList(model.getPrescriptions());
    }

    // --- Inner Class: Handles "Add Patient" Button Click ---
    private class AddPatientHandler implements CallbackAddPatient {
        @Override
        public Result<String, String> addPatient(String firstName, String lastName, Date dob,
                                                 String nhsNumber, String phone, String email, String address) {

            // Send data to Model
            Result<String, String> result = model.addPatient(firstName, lastName, dob, nhsNumber, phone, email, address);

            // If successful, update the table
            if (result.isOk()) {
                view.updatePatientList(model.getPatients());
            }
            return result;
        }
    }

    // --- Inner Class: Handles "Book Appointment" Button Click ---
    private class AddAppointmentHandler implements CallbackAddAppointment {
        @Override
        public Result<String, String> addAppointment(String patientId, String clinicianId, Date date, String time) {

            Result<String, String> result = model.addAppointment(patientId, clinicianId, date, time);

            if (result.isOk()) {
                view.updateAppointmentList(model.getAppointments());
            }
            return result;
        }
    }
    private class AddReferralHandler implements CallbackAddReferral {
        @Override
        public Result<String, String> addReferral(String patientId, String referrerId, String specialistId) {
            Result<String, String> result = model.addReferral(patientId, referrerId, specialistId);
            if (result.isOk()) view.updateReferralList(model.getReferrals());
            return result;
        }
    }

    private class AddPrescriptionHandler implements CallbackAddPrescription {
        @Override
        public Result<String, String> addPrescription(String patientId, String doctorId, String medication, String notes) {
            Result<String, String> result = model.addPrescription(patientId, doctorId, medication, notes);
            if (result.isOk()) view.updatePrescriptionList(model.getPrescriptions());
            return result;
        }
    }
}