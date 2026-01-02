import Healthcare.Model.AppointmentManager;
import Healthcare.View.HealthcareGUI;
import Healthcare.Controller.HealthcareController;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // 1. Initialize the Model (Loads data automatically)
                AppointmentManager model = AppointmentManager.getInstance();

                // 2. Initialize the View (The GUI)
                HealthcareGUI view = new HealthcareGUI();

                // 3. Initialize the Controller (Connects View and Model)
                new HealthcareController(view, model);

                // 4. Launch
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}