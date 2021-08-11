package manager;

import entity.Reminder;

import java.io.Serializable;
import java.util.HashMap;

public class ReminderManager implements Serializable {
    /**
     * Stores reminders (list)
     * Get reminder based on id(s) (method (list))
     * Add to storage (entity.Reminder)
     */
    private HashMap<Integer, Reminder> reminderList;

    public HashMap<Integer, Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(HashMap<Integer, Reminder> reminderList) {
        this.reminderList = reminderList;
    }

    public void addReminder(Reminder reminder)
    {
        reminderList.put(reminder.getReminderId(), reminder);
    }

    /**
     * Given a reminderId, return a reminder object that corresponds to that reminderId.
     * @param reminderId ReminderId to target
     * @return The reminder object.
     */
    public Reminder getReminder(int reminderId)
    {
        if (reminderList.get(reminderId) != null) {
            return reminderList.get(reminderId);
        }
        System.out.println("entity.Reminder not found.");
        return null;
    }
}
