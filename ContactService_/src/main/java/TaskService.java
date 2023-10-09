import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Task Service class that holds the functions and data structure for Task objects
 */

public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    private String id;

    /**
     * Add a task
     * @param name
     * @param description
     */
    public void addTask(String name, String description) {
        // Generate unique id

        id = generateId();
        Task task = new Task(id, name, description);

        for(int i = 0; i < taskList.size(); i++) {

            if (taskList.get(i).getId() == id ) {
                throw new IllegalArgumentException("Id already exists.");
            }
        }

        taskList.add(task);
    }

    /**
     * Delete task by id
     * @param id
     */
    public void deleteTask(String id) {

        // Iterate through list to find and remove contact
        for(int i = 0; i < taskList.size(); i++) {

            if (taskList.get(i).getId() == id ) {
                taskList.remove(i);
            }
            else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }
    }

    /**
     * Update task name by id
     * @param id
     * @param name
     */
    public void updateTaskName(String id, String name) {
        // Iterate through list to find contact and update with new contact
        for(int i = 0; i < taskList.size(); i++) {

            if (taskList.get(i).getId() == id ) {
               taskList.get(i).setName(name);
            }
            else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }

    }

    /**
     * Update task description by id
     * @param id
     * @param description
     */
    public void updateTaskDescription(String id, String description) {
        // Iterate through list to find contact and update with new contact
        for(int i = 0; i < taskList.size(); i++) {

            if (taskList.get(i).getId() == id ) {

                taskList.get(i).setDesc(description);
            }
            else {
                throw new IllegalArgumentException("Id does not exist.");
            }
        }

    }

    /**
     * Return list of current tasks
     * @return
     */
    public List<Task> getTasks() {return taskList;}

    /**
     * Generate a unique id 10 characters long.
     * @return
     */
    private String generateId() {
        String uuid = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
        return uuid;
    }
}
