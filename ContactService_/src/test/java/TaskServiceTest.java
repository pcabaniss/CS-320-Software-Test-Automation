import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Task testing class
 */
public class TaskServiceTest {
    private static String id = "1234567890";
    private String name = "John Smith";
    private String description = "This is a description about myself.";

    @Test
    @DisplayName("Basic test for adding a task")
    void taskServiceAddTest() {
        TaskService tService = new TaskService();
        tService.addTask(name, description);
        List<Task> tList = tService.getTasks();
        Task tester = tList.get(0);

        Assertions.assertTrue(tester.getName().equals("John Smith"));
        Assertions.assertTrue(tester.getDesc().equals("This is a description about myself."));

    }

    @Test
    @DisplayName("Basic test for deleting a task")
    void taskServiceDeleteTest() {
        TaskService tService = new TaskService();
        tService.addTask(name, description);
        List<Task> tList = tService.getTasks();
        Task tester = tList.get(0);

        Assertions.assertThrows(Exception.class, () -> tService.deleteTask("123456"));

        tService.deleteTask(tester.getId());
        Assertions.assertTrue(tService.getTasks().isEmpty());


    }

    @Test
    @DisplayName("Basic test for updating a task")
    void taskServiceUpdateTest() {

        TaskService tService = new TaskService();
        tService.addTask(name, description);

        List<Task> tList = tService.getTasks();
        String testId = tList.get(0).getId();

        tService.updateTaskName(testId, "Phillip Cabaniss");
        tService.updateTaskDescription(testId, "I am but a humble programmer.");

        tList = tService.getTasks();

        Assertions.assertTrue(tList.get(0).getName().equals("Phillip Cabaniss"));
        Assertions.assertTrue(tList.get(0).getDesc().equals("I am but a humble programmer."));
    }
}
