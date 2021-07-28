import java.io.File;

public class Main {
    public static void main (String[] args) {
        File f = new File("Files/ObjectManager.ser");
        if (f.exists() && !f.isDirectory()) {
            StateManager.restoreState();
        }
        else {
            f = new File("Files/");
            if (!f.exists() && !f.mkdirs()) {
                System.out.println("Error, could not make file, check permissions.");
            }
        }
        GameController.starterMenu();
    }
}
