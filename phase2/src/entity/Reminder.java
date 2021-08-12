package entity;

import java.io.Serializable;

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

    public String getTitle() {
        return title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public int getReminderId() {
        return reminderId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getLike() {
        return like;
    }

    public void addLike() {
        this.like = this.like + 1;
    }
}