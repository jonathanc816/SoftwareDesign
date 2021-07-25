import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        UserManager.addUser(UserManager.createUser("a", "a", false));
        GameController.starterMenu();
    }
}
