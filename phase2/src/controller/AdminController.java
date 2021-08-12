package controller;

import controller.inputChecker.UserNameChecker;
import controller.inputChecker.ValidUserChecker;
import entity.Pet;
import entity.User;
import manager.TemplateInfo;
import presenter.Presenter;
import timer.UserTimer;

import java.util.Set;

public class AdminController extends ManagerControl{
    /**
     * Shows admin options and allows interaction with different templates.
     */
    public static void adminMenu() {
        Presenter.showInstruction("Hi! admin user, "+LocalUserManager.getCurrentUser().getUsername());
        while (true) {
            Presenter.showMenu(new String[]{"Edit template info", "Manage Users", "Go Back"},
                    "\nThis is the admin settings menu, you can:");
            int userChoice = GameController.getUserNum(3);
            if (userChoice == 1) {
                editTemplateInfo();
            }
            else if (userChoice == 2) {
                viewUsers();
            }
            else {
                return;
            }
        }
    }

    public static void editTemplateInfo() {
        while (true) {
            Presenter.showMenu(
                    new String[]{"Pet template info", "Message template info", "Reminder template info", "Go back"},
                    "\nChoose the template info you want to edit:");
            int userChoice = GameController.getUserNum(4);
            if (userChoice == 1){
                editInfo(LocalPetManager, "pet");
            }
            else if (userChoice == 2){
                editInfo(LocalMessageManager, "message");
            }
            else if (userChoice == 3) {
                editInfo(LocalReminderManager, "reminder");
            }
            else {
                return;
            }
        }
    }

    public static void editInfo(TemplateInfo template, String name) {
        Presenter.showInstruction("The current message template information is:");
        Presenter.showInstruction("["+template.getTemplateInfo()+"]");
        Presenter.showInstruction("This information will be shown when people create a new "+name);
        String newIntro = GameController.getUserString("Now enter a new one...");
        template.setTemplateInfo(newIntro);
        Presenter.showInstruction("You have changed "+name+" template information to ["+
                template.getTemplateInfo()+"] successfully!");
    }

    public static void viewUsers() {
        Presenter.showInstruction("This is the user list, enter a username to manage...");
        Set<String> allUsers = LocalUserManager.getAllUserNames();
        for (String s: allUsers) {
            Presenter.showInstruction(s);
        }
        String adminInput = GameController.getUserString(new ValidUserChecker());
        User targetUser = LocalUserManager.getUserByName(adminInput);
        manageUser(targetUser);
    }

    public static void manageUser(User targetUser) {
        while (true) {
            Presenter.showMenu(new String[]{"Manage Pet", "Manage Reminder", "Suspend User", "Go Back"},
                    "You are managing the user named "+targetUser.getUsername()+", please select your option");
            int selection = GameController.getUserNum(4);
            if (selection == 1) {
                managePet(targetUser);
            }
            else if (selection == 2) {
                manageReminder(targetUser);
            }
            else if (selection == 3) {
                suspendUser(targetUser);
            }
            else {
                return;
            }
        }
    }

    public static void managePet(User targetUser) {
        int petId = targetUser.getPetId();
        Pet pet = LocalPetManager.findPet(petId);
        while (true) {
            Presenter.showInstruction(String.format("Here is the information of %s's pet:\n" +
                            "Name: %s\n" +
                            "Color: %s\n" +
                            "Sex: %s\n" +
                            "Greeting: %s\n" +
                            "Public/Private: %s\n",
                    targetUser.getUsername(),
                    pet.getPetName(),
                    pet.getPetColour(),
                    pet.getPetSex(),
                    pet.getGreeting(),
                    LocalPetManager.checkPublicity(targetUser.getPetId())));
            Presenter.showMenu(new String[]{"View Pet", "Delete Greeting", "Change Public/Private", "Go Back"},
                    "Please select your option");
            int choice = GameController.getUserNum(4);
            if (choice == 1) {
                PetController.viewPet(petId);
            }
            else if (choice == 2) {
                pet.setGreeting("[Greeting Deleted By Admin User]");
                Presenter.showInstruction("You have deleted the greeting message of "
                        +pet.getPetName()+ "successfully!\n");
            }
            else if (choice == 3) {
                boolean petPublic = GameController.getUserYesOrNo(
                        "Enter 'y' to make it public or 'n' to make it private");
                pet.setPublicity(petPublic);
                Presenter.showInstruction("You have change this pet to "+
                        LocalPetManager.checkPublicity(targetUser.getPetId())+" successfully!\n");
            }
            else {
                return;
            }
        }
    }

    public static void manageReminder(User targetUser){
        while (true) {
            Presenter.showInstruction(String.format("Here is the information of %s's reminder:\n" +
                    "Number of reminders: %d\n" +
                    "Public/Private: %s\n",
                    targetUser.getUsername(),
                    targetUser.getReminders().size(),
                    LocalReminderManager.checkPublic(targetUser)));

            Presenter.showMenu(new String[]{"View Reminder", "Reminder Setting", "Go Back"},
                    "Please select your option");

            int choice = GameController.getUserNum(3);
            if (choice == 1) {
                ReminderController.viewFriendReminder(targetUser);
            }
            else if (choice == 2) {
                ReminderController.reminderSetting(targetUser);
            }
            else {
                return;
            }
        }
    }

    public static void suspendUser(User targetUser) {
        Presenter.showInstruction(
                "Please enter the minutes you want to suspend "+targetUser.getUsername()+" (max: 50000)");
        int suspendTime = GameController.getUserNum(50000);
        LocalUserManager.addBlockBefore(targetUser, UserTimer.getTimeAfterMinutes(suspendTime));
        Presenter.showInstruction(
                "You have suspended "+targetUser.getUsername()+" for "+suspendTime+" minutes from now successfully!\n");
    }
}