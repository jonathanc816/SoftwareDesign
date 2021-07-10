public class ReminderManager {
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
    public  Reminder getReminder(String reminderId)
    {
        for (int i=0;i<reminderList.size();i++)
        {
            Reminder currReminder=reminderList.get(i)

            if (currReminder.getReminderId()==reminderId)
            {
                return currReminder;
            }

        }
    }
}
