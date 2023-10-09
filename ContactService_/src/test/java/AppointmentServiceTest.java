import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Date;

public class AppointmentServiceTest {

    private String id = "1234567890";

    Date date = new Date(2024,06, 22);

    private String description = "This is a description about my appointment.";



    @Test
    @DisplayName("Basic test for adding appointment")
    void addTest() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(date, description);

        List<Appointment> list = service.getAppointments();
        Appointment test = list.get(0);

        Assertions.assertTrue(test.getDate().equals(date));
        Assertions.assertTrue(test.getDesc().equals("This is a description about my appointment."));

    }


    @Test
    @DisplayName("Basic test for successful deletion")
    void deleteTest() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(date, description);

        List<Appointment> list = service.getAppointments();
        Appointment test = list.get(0);

        Assertions.assertThrows(Exception.class, () -> service.deleteAppointment("123456"));

        service.deleteAppointment(test.getId());
        Assertions.assertTrue(service.getAppointments().isEmpty());

    }

    @Test
    @DisplayName("Test for updating an appointment.")
    void updateTest() {
        AppointmentService service = new AppointmentService();
        service.addAppointment(date, description);
        List<Appointment> list = service.getAppointments();
        String testId = list.get(0).getId();

        service.updateAppointment(testId, "This is a brand new description.",
                new Date(2024, 05, 28));

        list = service.getAppointments();

        Assertions.assertTrue(list.get(0).getDate().equals(new Date(2024, 05, 28)));
        Assertions.assertTrue(list.get(0).getDesc().equals("This is a brand new description."));
    }

}
