import java.util.Scanner;
import java.util.ArrayList;

public class Controller {
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
        Scanner sc = new Scanner(System.in);
        System.out.println(instruction);
        return sc.nextLine();
    }

    static public void starterMenu() {
        Presenter.showMenu(new String[]{"Login", "Create a new user"}, "Welcome to Tamagochi, enter number to...");
        int input = getUserNum(2);
        if (input == 1) {
            System.out.println("Login");
            }
        if (input == 2) {
            System.out.println("Create");
            }
        }
    }
