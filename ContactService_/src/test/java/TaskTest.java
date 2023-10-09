import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {



    @Test
    @DisplayName("Basic test for Task class")
    void testTaskClass() {
        Task task = new Task("1234567890", "John Smith", "This is a description about myself.");

        Assertions.assertTrue(task.getId().equals("1234567890"));
        Assertions.assertTrue(task.getName().equals("John Smith"));
        Assertions.assertTrue(task.getDesc().equals("This is a description about myself."));

    }

    @Test
    @DisplayName("Testing fot too long")
    void testTaskTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            Task task = new Task("12345678900", "John Jacob Jinkle Himer Smith",
                    "This is a very lond description about myself, who is named after the great John Jinkle the first.");

        });
    }

    @Test
    @DisplayName("Testing for null values")
    void testTaskNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Task task = new Task(null, null, null);
        });
    }
}
