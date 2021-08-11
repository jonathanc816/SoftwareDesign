public class UserController extends ManagerControl {

    /**
     * Create a new user based on the users input, types include AdminUser, GuestUser, User
     * @param guest value of guest user setting
     */
    public static void createNewUser(boolean guest) {
        User newUser = null;
        if (!guest) {
            String username =
                    GameController.getUserString(new UserNameChecker(), "Please enter a new username...");
            String password = GameController.getUserString("Please enter a password...");
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
        Presenter.showInstruction("Welcome, " + LocalUserManager.getCurrentUser().getUsername() + "!");
        Presenter.showInstruction(LocalPetManager.getTemplateInfo());
        createUserPet();
    }

    public static void createUserPet() {
        User currentUser = LocalUserManager.getCurrentUser();
        String petName = GameController.getUserString("Please enter the name of your pet...");

        String[] colours = new String[] {"red", "yellow", "blue", "green"};
        Presenter.showMenu(colours, "Select your pet's colour (enter number to select)");
        String petColour = colours[GameController.getUserNum(4) - 1];

        String[] sex = new String[] {"male", "female"};
        Presenter.showMenu(sex, "Select your pet's sex (enter number to select)");
        String petSex = sex[GameController.getUserNum(2) - 1];

//        boolean petPublicity =
//                GameController.getUserYesOrNo("Would you like to make your pet public to your friends? (y/n)");

        int newPetId = LocalPetManager.createPet(petName, petColour, petSex, true, "No Status");
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
        if (justCreated || LocalUserManager.login(username, password)){
            boolean back = false;
            while (!back) {
                Presenter.showInstruction("\nWelcome, "+ LocalUserManager.getCurrentUser().getUsername()+"! What would you like to do?");
                Presenter.showMenu(new String[] {"Pet", "Mailbox", "Friends", "Admin Setting", "Logout"});
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
                    if (LocalUserManager.isCurrentUserAdmin()) {
                        AdminController.adminMenu();
                    }
                    else {
                        Presenter.showInstruction("Permission denied! You are not an admin user.");
                    }
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
            Presenter.showInstruction("Wrong username or password!");
        }
    }
}