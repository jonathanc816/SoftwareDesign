import java.util.ArrayList;

public class Presenter {
    /**
     * Shows some instruction to the user.
     * @param s Some instruction
     */
    static public void showInstruction(String s) {
        System.out.println(s);
    }

    /**
     * Shows a numbered list of menu options.
     * @param menu list of strings in the menu
     */
    static public void showMenu(String[] menu) {
        int i = 1;
        for (String line : menu){
            System.out.println(i+". "+line);
            i ++;
        }
    }

    /**
     * Shows a titled numbered list of menu options.
     * @param menu list of strings in the menu
     * @param title title of menu
     */
    static public void showMenu(String[] menu, String title) {
        System.out.println(title);
        showMenu(menu);
    }

    /**
     * Shows a numbered list of menu options.
     * @param menu arraylist of strings in the menu
     */
    static public void showMenu(ArrayList<String> menu) {
        int i = 1;
        for (String line : menu){
            System.out.println(i+". "+line);
            i ++;
        }
    }
    /**
     * Shows a titled numbered list of menu options.
     * @param menu list of strings in the menu
     * @param title title of menu
     */
    static public void showMenu(ArrayList<String> menu, String title) {
        System.out.println(title);
        showMenu(menu);
    }
}
