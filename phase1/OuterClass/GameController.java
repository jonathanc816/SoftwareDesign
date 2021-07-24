import java.util.Scanner;
import java.util.ArrayList;

public class GameController {
    static public String getUserString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
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
                return Integer.parseInt(userChoice);
            }
            System.out.println("Invalid number, please enter again");
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
        while (true) {
            Presenter.showMenu(new String[]{"Login", "Create a new user"}, "Welcome to Tamagochi, enter number to");
            int input = getUserNum(2);
            if (input == 1) {
                UserController.userLogin();
            }
            if (input == 2) {
                UserController.creatNewUser();
            }
        }
    }
}
