import Healthcare.Utility.CSVReader;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CSVReader appointments;
        //System.out.println(System.getProperty("user.dir"));
        try {
            appointments = new CSVReader("cw2data/appointments.csv");
            System.out.println(appointments.getData());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}