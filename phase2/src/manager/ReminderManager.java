package manager;

import entity.Reminder;
import entity.User;

import java.util.HashMap;

public class ReminderManager extends TemplateInfo {
    /**
     * Stores reminders (list)
     * Get reminder based on id(s) (method (list))
     * Add to storage (entity.Reminder)
     */
    public Integer reminderID = 0;
    private final HashMap<Integer, Reminder> reminderList = new HashMap<>();

    public ReminderManager() {
        setTemplateInfo("Now you are creating a reminder.");
    }

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

    public void addLike(int reminderID) {
        Reminder r = getReminder(reminderID);
        r.addLike();
    }

    public void markComplete(int reminderID) {
        Reminder r = getReminder(reminderID);
        r.setCompleted(true);
    }

    public Reminder getReminder(int reminderId) {
        if (reminderList.get(reminderId) != null) {
            return reminderList.get(reminderId);
        }
        System.out.println("Reminder not found.");
        return null;
    }

    public String checkPublic(User user) {
        if (user.isReminderPublic()) {
            return "public";
        }
        return "private";
    }
}
