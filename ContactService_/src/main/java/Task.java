import java.util.UUID;

public class Task {

    private String id;
    private String name;
    private String description;

    /**
     * Basic Task object
     * @param id
     * @param name
     * @param description
     */
    public Task(String id, String name, String description) {

        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }


        this.id = id;
        this.name = name;
        this.description = description;

    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    protected String getId() {
        return id;
    }
}
