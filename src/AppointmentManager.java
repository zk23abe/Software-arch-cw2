import java.util.ArrayList;
import java.util.Date;

public class AppointmentManager {
    private AppointmentManager(){
        appointments = new ArrayList<>();
        patients = new ArrayList<>();
        clinicians = new ArrayList<>();
        referrals = new ArrayList<>();
    }
    public static AppointmentManager getInstance(){
        if(appointmentManager==null){
            appointmentManager=new AppointmentManager();
        }
        return appointmentManager;
    }
    public void createAppointment(String appointmentId,Patient patient, Clinician clinician, Date date){
        this.appointments.add(new Appointment(appointmentId,patient.getpatientID(),clinician.getPersonId(),date));
    }

    public void modifyAppointment(String AppointmentId){

    }
    public ArrayList<Appointment> getAppointments(){
        return this.appointments;
    }
    public ArrayList<Patient> getPatients(){
        return this.patients;
    }

    public void cancelAppointment(String appointmentId){
        for(Appointment appointment : this.appointments){
            if(appointment.getAppointmentId().equals(appointmentId)){
                appointments.remove(appointment);
                return;
            }
        }
    }

    static AppointmentManager appointmentManager = null;

    private ArrayList <Appointment> appointments = null;
    private ArrayList <Patient> patients = null;
    private ArrayList <Clinician> clinicians = null;
    private ArrayList <Referral> referrals = null;


}
