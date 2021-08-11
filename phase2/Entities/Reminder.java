import java.io.Serializable;
import java.util.Date;

public class Reminder implements Serializable {
    private final String title;
    private final String description;
    private Date dateDue;
    private boolean completed;
    private final int reminderId;

    /**
     * The constructor of Reminder
     *
     * @param title       The unique title of a reminder
     * @param description The content of the reminder
     * @param dateDue     The due date of the reminder
     * @param completed   Whether the things in reminder is done (can be changed by user)
     * @param reminderId  the unique id of the reminder
     */
    public Reminder(String title, String description, Date dateDue, boolean completed, int reminderId) {
        this.title = title;
        this.description = description;
        this.dateDue = dateDue;
        this.completed = completed;
        this.reminderId = reminderId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public boolean getCompleted() {
        return completed;
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}