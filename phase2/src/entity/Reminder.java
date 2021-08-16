package entity;

import java.io.Serializable;

/**
 * The class that represents a pet
 */
public class Reminder implements Serializable {
    private final String title;
    private boolean completed;
    private final int reminderId;
    private int like = 0;

    /**
     * The constructor of entity.Reminder
     *
     * @param title       The unique title of a reminder
     * @param completed   Whether the things in reminder is done (can be changed by user)
     * @param reminderId  the unique id of the reminder
     */
    public Reminder(String title, boolean completed, int reminderId) {
        this.title = title;
        this.completed = completed;
        this.reminderId = reminderId;
    }

    /**
     * @return The title of this reminder
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Completion status of this reminder
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * @return Get a reminderid
     */
    public int getReminderId() {
        return reminderId;
    }

    /**
     * @param completed set completion
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * @return get like amounts of this reminder
     */
    public int getLike() {
        return like;
    }

    /**
     * add one like to this reminder
     */
    public void addLike() {
        this.like = this.like + 1;
    }
}