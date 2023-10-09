import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    Date date = new Date(2024,06, 22);
    Date inPast = new Date();
    @Test
    @DisplayName("Basic test fot appointment class")
    void appointmentTest() {
        Appointment test = new Appointment("0123456789", date, "This is a test description for the testing of the test.");

        Assertions.assertTrue(test.getId().equals("0123456789"));
        Assertions.assertTrue(test.getDate().equals(date));
        Assertions.assertTrue(test.getDesc().equals("This is a test description for the testing of the test."));
    }

    @Test
    @DisplayName("Testing if id and description is too long")
    void testTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Appointment test = new Appointment("01234567890", date, "This description is going to be a very long and should cause an error to be thrown.");

        });
    }

    @Test
    @DisplayName("Testing for null values")
    void testTaskNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment test = new Appointment(null, null, null);
        });
    }

    @Test
    @DisplayName("Testing for date in past")
    void pastTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Appointment test = new Appointment("1234567890", inPast, "This is a description.");
        });
    }
}
