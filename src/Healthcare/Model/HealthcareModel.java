package Healthcare.Model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Healthcare.View.HealthcareGUI;
import Healthcare.Utility.CSVReader;


// If CSVReader is in a different package (e.g., healthcare.util), import it here.
// import healthcare.util.CSVReader;

public class HealthcareModel {

    private AppointmentManager appointmentManager;

    // File paths (Ensure these match your actual project folder structure)
    private static final String PATIENTS_FILE = "cw2data/patients.csv";
    private static final String CLINICIANS_FILE = "cw2data/clinicians.csv";
    private static final String APPOINTMENTS_FILE = "cw2data/appointments.csv";

    public HealthcareModel() {
        this.appointmentManager = AppointmentManager.getInstance();
        loadAllData();
    }

    private void loadAllData() {
        try {
            loadPatients();
            loadClinicians();
            loadAppointments();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- CSV Loading Logic ---

    private void loadPatients() throws IOException {
        CSVReader reader = new CSVReader(PATIENTS_FILE);
        ArrayList<ArrayList<String>> data = reader.getData();

        // Skip header if your CSVReader includes it.
        // Assuming CSVReader.getData() returns raw rows.
        for (ArrayList<String> row : data) {
            if (row.isEmpty()) continue;
            // Map CSV columns to Patient Constructor
            // Adjust indices [0], [1] based on your specific CSV structure
            try {
                String id = row.get(0);
                String first = row.get(1);
                String last = row.get(2);
                // Parsing DOB etc. omitted for brevity, passing strings/dummy dates if needed
                // String dob = row.get(3);
                String address = row.get(8); // Example index

                // Note: You might need to adjust the Patient constructor or parsing logic
                Patient p = new Patient(id, "Medical Record N/A", first, last, address);
                appointmentManager.getPatients().add(p);
            } catch (Exception e) {
                // Skip malformed rows
            }
        }
    }

    private void loadClinicians() throws IOException {
        CSVReader reader = new CSVReader(CLINICIANS_FILE);
        ArrayList<ArrayList<String>> data = reader.getData();

        for (ArrayList<String> row : data) {
            if (row.isEmpty()) continue;
            try {
                String id = row.get(0);
                String first = row.get(1);
                String last = row.get(2);
                String role = row.get(3);

                // Logic to distinguish Specialist vs Clinician
                if (role.equalsIgnoreCase("Consultant")) {
                    // Create Specialist
                    // Assuming you have the Specialist class we created earlier
                    String speciality = row.get(4);
                    Specialist s = new Specialist(id, first + " " + last, new Date(), false, speciality);
                    // Add to a clinician list in manager (you might need to cast or have a separate list)
                    // appointmentManager.getClinicians().add(s);
                } else {
                    // Create regular Clinician
                    Clinician c = new Clinician(id, first + " " + last, new Date(), false);
                    // appointmentManager.getClinicians().add(c);
                }
            } catch (Exception e) {
                // Skip
            }
        }
    }

    private void loadAppointments() throws IOException {
        CSVReader reader = new CSVReader(APPOINTMENTS_FILE);
        ArrayList<ArrayList<String>> data = reader.getData();

        for (ArrayList<String> row : data) {
            if (row.isEmpty()) continue;
            try {
                String apptId = row.get(0);
                String patId = row.get(1);
                String docId = row.get(2);
                String dateStr = row.get(4); // 2025-09-20

                // Parse Date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(dateStr);

                // Use Manager to find objects (or just store IDs depending on your Appointment class)
                // Assuming Appointment stores IDs:
                appointmentManager.getAppointments().add(new Appointment(apptId, patId, docId, date));
            } catch (Exception e) {
                // Skip
            }
        }
    }

    // --- Data Access Methods for the GUI/Controller ---

    public ArrayList<Appointment> getAllAppointments() {
        return appointmentManager.getAppointments();
    }

    public ArrayList<Referral> getAllReferrals() {
        return appointmentManager.getReferrals();
    }

    public Patient getPatient(String patientId) {
        for (Patient p : appointmentManager.getPatients()) {
            if (p.getpatientID().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    public Clinician getClinician(String clinicianId) {
        // You'll need to add a getClinicians() method to AppointmentManager if it's missing
        // For now, returning dummy or implementing search:
        /*
        for (Clinician c : appointmentManager.getClinicians()) {
            if (c.getPersonId().equals(clinicianId)) return c;
        }
        */
        return null;
    }

    // --- Action Methods ---

    public void bookAppointment(String id, String patientId, String clinicianId, Date date) {
        // Find objects if needed, or pass IDs
        Patient p = getPatient(patientId);
        Clinician c = getClinician(clinicianId);

        if (p != null) {
            // Clinician might be null if we didn't implement that load logic fully yet
            // passing null for clinician if your createAppointment handles it, otherwise handle error
            appointmentManager.createAppointment(id, p, c, date);
        }
    }

    public void createReferral(String refId, String patientId, String referrerId, String specialistId) {
        Patient p = getPatient(patientId);
        Clinician referrer = getClinician(referrerId);

        // You need to cast to Specialist or find in specialist list
        Clinician possibleSpec = getClinician(specialistId);
        Specialist specialist = (possibleSpec instanceof Specialist) ? (Specialist) possibleSpec : null;

        if (p != null && referrer != null && specialist != null) {
            appointmentManager.createReferral(refId, referrer, specialist, p);
        }
    }

    public void saveData() {
        // Implement logic to write back to CSVs if required
        System.out.println("Saving data...");
    }
}
