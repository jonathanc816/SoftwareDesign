import java.util.Scanner;
import java.util.ArrayList;

public class GameController {
    static public String getUserString() {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        System.out.println();
        return userInput;
    }

    static public int getUserNum(int maxNum) {
        ArrayList<String> choices = new ArrayList<>();
        for (int i=1; i<maxNum+1; i++) {
            choices.add(Integer.toString(i));
        }
        Scanner sc = new Scanner(System.in);

        while (true) {
            String userChoice = sc.nextLine();
            if (choices.contains(userChoice)) {
                System.out.println();
                return Integer.parseInt(userChoice);
            }
            System.out.println("Invalid number, please try again");
        }

    }

    static public int getUserNum() {
        return getUserNum(999);
    }

    static public String getUserString(String instruction) {
        System.out.println(instruction);
        return getUserString();
    }

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

    static public String getUserString(ValidationChecker p, String instruction) {
        System.out.println(instruction);
        return getUserString(p);
    }

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

    static public boolean getUserYesOrNo(String instruction) {
        System.out.println(instruction);
        return getUserYesOrNo();
    }

    static public void starterMenu() {
        boolean justCreated = false;
        while (true) {
            if (justCreated) {
                UserController.userLogin(true);
                justCreated = false;
            }
            Presenter.showMenu(new String[]{"Login", "Create a new user", "Create a new guest user."}, "\nWelcome to Tamagochi, enter a number to");
            int input = getUserNum(3);
            if (input == 1) {
                UserController.userLogin(false);
            }
            if (input == 2) {
                UserController.createNewUser(false);
                justCreated = true;
            }
            if (input == 3) {
                UserController.createNewUser(true);
                justCreated = true;
            }
        }
    }
}
