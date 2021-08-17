package controller;

import controller.inputChecker.NoneEmptyChecker;
import entity.User;
import presenter.Presenter;

import java.util.ArrayList;

public class ReminderController extends ManagerControl{
    /**
     * Show menu for reminders.
     */
    public static void reminderMenu() {
        while(true) {
            Presenter.showMenu(new String[]{"Create Reminder", "View Reminder", "Reminder Setting", "Go Back"},
                    "Hi, this is your reminder menu, you could");
            int choice = GameController.getUserNum(4);
            if (choice == 1) {
                createReminder();
            }
            else if (choice == 2) {
                User user = LocalUserManager.getCurrentUser();
                viewMyReminder(user);
            }
            else if (choice == 3) {
                User user = LocalUserManager.getCurrentUser();
                reminderSetting(user);
            }
            else {
                return;
            }
        }
    }

    public static void createReminder() {
        Presenter.showInstruction(LocalReminderManager.getTemplateInfo());
        String title = GameController.getUserString(new NoneEmptyChecker(),
                "Please enter the title of the reminder...");
        int reminderId = LocalReminderManager.addReminder(title);
        LocalUserManager.getCurrentUser().addReminderId(reminderId);
        Presenter.showNotice("You have created a new reminder successfully\n");
    }

    public static int showReminders(User user) {
        ArrayList<Integer> reminderList = user.getReminders();
        if (reminderList.size() == 0) {
            Presenter.showNotice("Empty reminder list\n");
            return -1;
        }
        else {
            int i = 1;
            for (Integer reminderId : reminderList) {
                Presenter.showInstruction(i+". "+LocalReminderManager.getReminderInfo(reminderId));
                i = i + 1;
            }
            Presenter.showInstruction(i+". Go Back");
            return i;
        }
    }

    public static void viewMyReminder(User user){
        while (true) {
            int i = showReminders(user);
            if (i < 0) {return;}

            Presenter.showInstruction("Enter the number of a reminder to see more...");
            int choice = GameController.getUserNum(i);
            if (choice == i) {
                return;
            }

            ArrayList<Integer> reminderList = user.getReminders();
            int targetReminderID = reminderList.get(choice - 1);

            Presenter.showMenu(new String[]{"Mark Complete", "Mark Incomplete", "Like It", "Go Back"}, "For reminder ("+choice+"), you can:");
            int choice2 = GameController.getUserNum(4);
            if (choice2 == 1) {
                LocalReminderManager.markComplete(targetReminderID);
                Presenter.showNotice("You have marked reminder ("+choice+") as complete successfully!\n");
            }
            else if (choice2 == 2) {
                LocalReminderManager.markIncomplete(targetReminderID);
                Presenter.showNotice("You have marked reminder ("+choice+") as incomplete successfully!\n");
            }
            else if (choice2 == 3) {
                LocalReminderManager.addLike(targetReminderID);
                Presenter.showNotice("Reminder ("+choice+")'s like +1\n");
            }
        }
    }

    public static void viewFriendReminder(User user){
        while (true) {
            int i = showReminders(user);
            if (i < 0) {
                return;
            }

            Presenter.showInstruction("Enter the number of a reminder to like it...");
            int choice = GameController.getUserNum(i);
            if (choice == i) {
                return;
            }

            ArrayList<Integer> reminderList = user.getReminders();
            int targetReminderID = reminderList.get(choice - 1);
            LocalReminderManager.addLike(targetReminderID);
            Presenter.showNotice("Reminder ("+choice+")'s like +1\n");
        }
    }

    public static void reminderSetting(User user){
        while (true) {
            Presenter.showMenu(new String[]{"Delete Reminders", "Set Public/Private", "Go Back"},
                    "This is the reminder setting page of "+user.getUsername()+", you could:");
            int choice = GameController.getUserNum(3);
            if (choice == 1) {
                boolean delete = GameController.getUserYesOrNo(
                        "Are you sure to delete all reminders? 'y' for yes, 'n' for no.");
                if (delete) {
                    user.cleanReminders();
                    Presenter.showNotice("You have deleted all reminders successfully!\n");
                }
            }
            else if (choice == 2) {
                boolean reminderPublic = GameController.getUserYesOrNo(
                        "Your reminder is "+LocalReminderManager.checkPublic(user)+" to others now.\n" +
                                "Enter 'y' to make it public or 'n' to make it private");
                user.setReminderPublic(reminderPublic);
                Presenter.showNotice("You have change your reminder to "+
                        LocalReminderManager.checkPublic(user)+" successfully!\n");
            }
            else {
                return;
            }
        }
    }
}
