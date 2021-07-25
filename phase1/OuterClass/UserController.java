public class UserController {
    static public void creatNewUser() {
        String username =
                GameController.getUserString(new UserNameChecker(), "Please enter new user name...");
        String password = GameController.getUserString("Please enter the password...");
        boolean isAdmin = GameController.getUserYesOrNo("Are you a admin user? (y/n)");
        User newUser = UserManager.createUser(username, password, isAdmin);
        UserManager.addUser(newUser);

        Presenter.showInstruction("Welcome! " + username + ". Now choose your pet!");
        createUserPet();
    }

    static public void createUserPet() {
        User currentUser = UserManager.currentUser;
        String petName = GameController.getUserString("Please enter the name of your pet...");

        String[] colours = new String[] {"red", "yellow", "blue", "green"};
        Presenter.showMenu(colours, "Please set the colour (enter number to select)");
        String petColour = colours[GameController.getUserNum(4) - 1];

        String[] sex = new String[] {"male", "female"};
        Presenter.showMenu(sex, "Please set sex of your pet (enter number to select)");
        String petSex = sex[GameController.getUserNum(2) - 1];

//        boolean petPublicity =
//                GameController.getUserYesOrNo("Would you like to make your pet public to your friends? (y/n)");

        Pet newPet = PetManager.createPet(
                petName, currentUser.getPetId(), petColour, petSex, true, "No Status");
        Presenter.showInstruction(
                "Congratulations! "+currentUser.getUsername()+". You now have a "+petColour+"," +
                        " "+petSex+" pet called "+petName+". Login to see more.");
    }

    static public void userLogin() {
        String username = GameController.getUserString("Please enter your user name...");
        String password = GameController.getUserString("Please enter the password...");
        if (UserManager.login(username, password)){
            boolean back = false;
            while (!back) {
                Presenter.showInstruction("\nWelcome back! "+UserManager.currentUser.getUsername()+". choose your option");
                Presenter.showMenu(new String[] {"Pet", "Mailbox", "Friends", "Logout"});
                int userChoice = GameController.getUserNum(4);
                if (userChoice == 1) {
                    PetController.petMenu();
                }
                else if (userChoice == 2) {
                    MessageController.mailbox();
                }
                else if (userChoice == 3){
                    FriendController.friendMenu();
                }
                else {back = true;}
            }
        }
        else {
            Presenter.showInstruction("Wrong username or password!");
        }
    }
}