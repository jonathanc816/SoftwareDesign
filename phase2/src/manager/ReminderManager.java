package manager;

import entity.Reminder;
import entity.User;

import java.util.HashMap;

/**
 * Stores reminders (hashmap)
 * Get reminder based on id(s) (method (hashmap))
 * Add to storage (entity.Reminder)
 */
public class ReminderManager extends TemplateInfo {
    /** The ID attached to the Reminder object to be retrieved */
    public Integer reminderID = 0;
    /** A hashmap that maps the reminder ID to the Reminder object */
    private final HashMap<Integer, Reminder> reminderList = new HashMap<>();

    /**
     * Initializer for ReminderManager
     */
    public ReminderManager() {
        setTemplateInfo("Now you are creating a reminder.");
    }

    /**
     * @param title reminder title
     * @return return the reminder id
     */
    public int addReminder(String title)
    {
        Reminder reminder = new Reminder(title, false, this.reminderID);
        reminderList.put(this.reminderID, reminder);
        this.reminderID += 1;
        return this.reminderID - 1;
    }

    /**
     * Given a reminderId, return a reminder object that corresponds to that reminderId.
     * @param reminderId ReminderId to target
     * @return The reminder object.
     */
    public String getReminderInfo(int reminderId)
    {
        Reminder r = getReminder(reminderId);
        if (r.getCompleted()) {
            return r.getTitle()+" COMPLETE, like("+r.getLike()+")";
        }
        return r.getTitle()+" INCOMPLETE, like("+r.getLike()+")";
    }

    /**
     * add like to reminder
     * @param reminderID reminder to search
     */
    public void addLike(int reminderID) {
        Reminder r = getReminder(reminderID);
        r.addLike();
    }

    /**
     * mark a reminder as complete
     * @param reminderID reminder to mark as complete
     */
    public void markComplete(int reminderID) {
        Reminder r = getReminder(reminderID);
        r.setCompleted(true);
    }

    public void markIncomplete(int reminderID) {
        Reminder r = getReminder(reminderID);
        r.setCompleted(false);
    }

    /**
     * @param reminderId reminderid to get
     * @return The reminder
     */
    public Reminder getReminder(int reminderId) {
        if (reminderList.get(reminderId) != null) {
            return reminderList.get(reminderId);
        }
        System.out.println("Reminder not found.");
        return null;
    }

    /**
     * @param user User object to check if public
     * @return Status of user publicity
     */
    public String checkPublic(User user) {
        if (user.isReminderPublic()) {
            return "public";
        }
        return "private";
    }
}
