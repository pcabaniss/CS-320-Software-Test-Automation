import java.util.Date;

public class Appointment {

    private static String id;

    private Date date;

    private String desc;

    public Appointment(String id, Date date, String desc) {
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id.");
        }

        if(date.before(new Date())) {
            throw new IllegalArgumentException("Invalid data, date is in the past.");
        }

        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }

        this.id = id;
        this.date = date;
        this.desc = desc;

    }

    // Setters
    public void setDate(Date date) {

        if(date.before(new Date())) {
            throw new IllegalArgumentException("Invalid data, date is in the past.");
        }

        this.date = date;
    }

    public void setDesc(String desc) {

        if (desc == null || desc.length() > 50) {
            throw new IllegalArgumentException("Invalid description.");
        }

        this.desc = desc;
    }

    // Getters
    public Date getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    protected String getId() {
        return id;
    }
}
