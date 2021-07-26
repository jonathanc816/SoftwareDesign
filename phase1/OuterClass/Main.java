import java.io.File;

public class Main {
    public static void main (String[] args) {
        File f = new File("Files/ObjectManager.ser");
        if (f.exists() && !f.isDirectory()) {
            StateManager.restoreState();
        }
        GameController.starterMenu();
    }
}
