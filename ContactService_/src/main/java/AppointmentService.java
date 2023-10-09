import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

    private List<Appointment> apptList = new ArrayList<>();

    private String id;

    /**
     * Add an appointment
     * @param date
     * @param desc
     */

    public void addAppointment(Date date, String desc) {
        id = generateId();

        Appointment appt = new Appointment(id, date, desc);
        for(int i = 0; i < apptList.size(); i++) {

            if (apptList.get(i).getId() == id ) {
                throw new IllegalArgumentException("Id already exists.");
            }
        }

        apptList.add(appt);
    }

    /**
     * Delete appointment by id
     * @param id
     */
    public void deleteAppointment(String id) {

        // Iterate through list to find and remove appointment
        for(int i = 0; i < apptList.size(); i++) {

            if (apptList.get(i).getId() == id ) {
                apptList.remove(i);
            }
            else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }
    }

    /**
     * Update an appointment by id
     * @param id
     * @param desc
     * @param date
     */
    public void updateAppointment(String id, String desc, Date date) {

        // Iterate through list to find appointment and update with new appointment
        for (int i = 0; i < apptList.size(); i++) {

            if (apptList.get(i).getId() == id) {
                apptList.get(i).setDesc(desc);
                apptList.get(i).setDate(date);
            } else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }
    }

    /**
     * Return the current list of appointments
     * @return
     */
    public List<Appointment> getAppointments() {
        return apptList;
    }

    /**
     * Generate a unique id 10 characters long.
     * @return
     */
    private String generateId() {
        String uuid = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
        return uuid;
    }
}
