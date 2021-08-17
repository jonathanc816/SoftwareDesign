package controller;

import controller.inputChecker.ValidationChecker;
import presenter.Presenter;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Controller for games.
 */
public class GameController {
    /**
     * This function takes in a users input and returns it as a string.
     * @return Users inputted string
     */
    static public String getUserString() {
        Scanner sc = new Scanner(System.in); // Keep Scanner open, otherwise other instances will be unable to read from the InputStream source
        String userInput = sc.nextLine();
        System.out.println();
        return userInput;
    }

    /**
     * Queries the user for a choice of number between 1-maxNum of options. Validates user input to be inbetween
     * that range.
     * @param maxNum The highest number a user can input
     * @return The number the user chose
     */
    static public int getUserNum(int maxNum) {
        HashMap<String, Integer> choices = new HashMap<>();
        for (int i=1; i<maxNum+1; i++) {
            choices.put(Integer.toString(i), 0);
        }
        Scanner sc = new Scanner(System.in);

        while (true) {
            String userChoice = sc.nextLine();
            if (choices.containsKey(userChoice)) {
                System.out.println();
                return Integer.parseInt(userChoice);
            }
            System.out.println("Invalid number, please try again");
        }

    }

    /**
     * Get a users string (calling getUserString) while displaying the instructions.
     * @param instruction The instructions to display
     * @return Choice of user
     */
    static public String getUserString(String instruction) {
        System.out.println(instruction);
        return getUserString();
    }

    /**
     * Verifies a users string with the criteria defined in the class p. Gives a warning defined in
     * class p when the input is invalid.
     * @param p Some subclass of controller.inputChecker.ValidationChecker
     * @return Validated userInput string.
     */
    static public String getUserString(ValidationChecker p) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (p.check(userInput)) {
                System.out.println();
                return userInput;
            }
            System.out.println(p.warning());
        }
    }

    /**
     * Verifies a users string with the criteria defined in the class p. Gives a warning defined in
     * class p when invalid. Also outputs the instruction before getting user input.
     * @param p Some subclass of controller.inputChecker.ValidationChecker
     * @param instruction Some string of instructions
     * @return Validated string
     */
    static public String getUserString(ValidationChecker p, String instruction) {
        System.out.println(instruction);
        return getUserString(p);
    }

    /**
     * Gets a simple y/n response from the user.
     * @return Boolean value from y/n input
     */
    static public boolean getUserYesOrNo() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String userInput = sc.nextLine();
            if (userInput.equals("y") || userInput.equals("n")) {
                System.out.println();
                return userInput.equals("y");
            }
            System.out.println("Invalid choice, enter 'y' for yes or 'n' for no");
        }
    }

    /**
     * Gets simple y/n input from the user and displays instruction before that.
     * @param instruction Some instruction to display to the user
     * @return boolean value from y/n input
     */
    static public boolean getUserYesOrNo(String instruction) {
        System.out.println(instruction);
        return getUserYesOrNo();
    }

    /**
     * Creates a session for presentation to the user and allows login/creation of users
     */
    static public void starterMenu() {
        boolean justCreated = false;
        while (true) {
            if (justCreated) {
                UserController.userLogin(true);
                justCreated = false;
            }
            Presenter.showMenu(new String[]{"Login", "Create a New User", "Other User", "Exit"}, "\nWelcome to Tamagochi, enter a number to");
            int input = getUserNum(4);
            if (input == 1) {
                UserController.userLogin(false);
            }
            else if (input == 2) {
                UserController.createNewUser(false, false);
                justCreated = true;
            }
            else if (input == 3) {
                Presenter.showMenu(new String[]{"Guest User", "Temporary User"}, "Choose a special user to create...");
                int input2 = getUserNum(2);
                if (input2 == 1) {
                    UserController.createNewUser(true, false);
                    justCreated = true;
                }
                else if (input2 == 2) {
                    UserController.createNewUser(false, true);
                    justCreated = true;
                }
            }
            else {
                Presenter.showMenu(new String[]{}, "Thanks for playing Tamagochi. Bye!");
                return;
            }
        }
    }
}
