public class UserController {
    static public void creatNewUser() {
        String username =
                GameController.getUserString(new UserNameChecker(), "Please enter new user name...");
        String password = GameController.getUserString("Please enter the password...");
        boolean isAdmin = GameController.getUserYesOrNo("Are you a admin user? (y/n)");
        User newUser = UserManager.createUser(username, password, isAdmin);
        UserManager.addUser(newUser);
        Presenter.showInstruction("Welcome! " + username + ". Now choose your pet!");
        // TODO create pet
    }

    static public void userLogin() {
        String username = GameController.getUserString("Please enter your user name...");
        String password = GameController.getUserString("Please enter the password...");
        if (UserManager.login(username, password)){
            Presenter.showInstruction("Welcome back! "+UserManager.currentUser.getUsername()+". choose your option");
            Presenter.showMenu(new String[] {"Pet", "Mailbox", "Friends"});
        }
        else {
            Presenter.showInstruction("Wrong username or password!");
        }
    }
}