import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReminderManager implements Serializable {
    /**
     * Stores reminders (list)
     * Get reminder based on id(s) (method (list))
     * Add to storage (Reminder)
     */
    private List<Reminder> reminderList;

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }

    public void addReminder(Reminder reminder)
    {
        reminderList.add(reminder);
    }

    public  Reminder getReminder(int reminderId)
    {
        for (Reminder currReminder : reminderList) {
            if (currReminder.getReminderId() == reminderId) {
                return currReminder;
            }

        }
        return new Reminder("", "", new Date(), false, 0);
        //should raise an error or return an empty reminder if reminderId not in list
    }
}
