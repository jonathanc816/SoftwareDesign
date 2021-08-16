package controller;

import controller.inputChecker.UserNameChecker;
import controller.inputChecker.WeakPasswordChecker;
import entity.User;
import gateway.StateManager;
import manager.LoginStatus;
import presenter.Presenter;
import timer.UserTimer;

/**
 * Controller for users.
 */
public class UserController extends ManagerControl {

    /**
     * Create a new user based on the users input, types include entity.AdminUser, entity.GuestUser, entity.User
     * @param guest value of guest user setting
     */
    public static void createNewUser(boolean guest, boolean temporary) {
        User newUser = null;
        if (!guest) {
            String username =
                    GameController.getUserString(new UserNameChecker(), "Please enter a new username...");
            String password = GameController.getUserString(new WeakPasswordChecker(), "Please enter a password...");
            boolean isAdmin = GameController.getUserYesOrNo("Are you an admin user? (y/n)");
            if (isAdmin) {
                newUser = LocalUserManager.createAdminUser(username, password);
            }
            else {
                newUser = LocalUserManager.createUser(username, password);
            }
        }
        else {
            newUser = LocalUserManager.createGuestUser();
        }
        LocalUserManager.addUser(newUser);

        if (temporary) {
            Presenter.showInstruction("Please enter the minutes you want to try (max: 50000).\n" +
                    "Note that you can no longer access it after time is up.");
            int trail = GameController.getUserNum(50000);
            LocalUserManager.addBlockAfter(newUser, UserTimer.getTimeAfterMinutes(trail));
        }

        Presenter.showInstruction("Welcome, " + LocalUserManager.getCurrentUser().getUsername() + "!");
        Presenter.showInstruction(LocalPetManager.getTemplateInfo());
        createUserPet();
    }

    /**
     * Create a pet for a user based on the input values.
     */
    public static void createUserPet() {
        User currentUser = LocalUserManager.getCurrentUser();
        String petName = GameController.getUserString("Please enter the name of your pet...");

        String[] colours = new String[] {"red", "yellow", "blue", "green"};
        Presenter.showMenu(colours, "Select your pet's colour (enter number to select)");
        String petColour = colours[GameController.getUserNum(4) - 1];

        String[] sex = new String[] {"male", "female"};
        Presenter.showMenu(sex, "Select your pet's sex (enter number to select)");
        String petSex = sex[GameController.getUserNum(2) - 1];

        String greeting = GameController.getUserString("Please enter the greeting your pet would say...");

        int newPetId = LocalPetManager.createPet(
                petName, petColour, petSex, true, "No Status", greeting);
        LocalUserManager.getCurrentUser().setUserPetId(newPetId);
        Presenter.showInstruction(
                "Congratulations, "+currentUser.getUsername()+"! You now have a "+petColour+"," +
                        " "+petSex+" pet named "+petName+".");
    }

    /**
     * Go through authentication provess for the user, unless the user account was just created. Displays basic menu
     * window
     * @param justCreated Boolean value that skips login process if user account was just created
     */
    public static void userLogin(boolean justCreated) {
        String username = null;
        String password = null;
        if (!justCreated) {
            username = GameController.getUserString("Please enter your username...");
            password = GameController.getUserString("Please enter the password...");
        }

        LoginStatus loginStatus = LocalUserManager.login(username, password);
        if (justCreated || loginStatus.success){
            boolean back = false;
            while (!back) {
                Presenter.showMenu(new String[] {"Pet", "Mailbox", "Friends", "Setting", "Logout"},
                        "\nWelcome, "+ LocalUserManager.getCurrentUser().getUsername()+"! What would you like to do?");
                int userChoice = GameController.getUserNum(5);
                if (userChoice == 1) {
                    PetController.petMenu();
                }
                else if (userChoice == 2) {
                    MessageController.mailbox();
                }
                else if (userChoice == 3){
                    FriendController.friendMenu();
                }
                else if (userChoice == 4){
                    settingMenu();
                }
                else {
                    if (LocalUserManager.isCurrentUserGuest()) {
                        LocalUserManager.deleteUser("guest");
                    }
                    LocalUserManager.setCurrentUser(null);
                    StateManager.saveState();
                    back = true;
                }
            }
        }
        else {
            Presenter.showError(loginStatus.information);
        }
    }

    /**
     * Menu for settings, allows you to change password, report issues or access admin panel.
     */
    public static void settingMenu() {
        while(true) {
            Presenter.showMenu(new String[]{"Change Password", "Report Issue", "Admin Setting", "Back"},
                    "This is the setting menu, enter a number to...");
            int choice = GameController.getUserNum(4);
            if (choice == 1) {
                String newPassword = GameController.getUserString(new WeakPasswordChecker(), "Please enter a new password...");
                LocalUserManager.changePassword(LocalUserManager.getCurrentUser(), newPassword);
                Presenter.showNotice("You have changed you password successfully!\n");
            }
            else if (choice == 2) {
                MessageController.createReport();
            }
            else if (choice == 3) {
                if (LocalUserManager.isCurrentUserAdmin()) {
                    AdminController.adminMenu();
                }
                else {
                    Presenter.showError("Permission denied! You are not an admin user.\n");
                }
            }
            else {
                return;
            }
        }
    }
}