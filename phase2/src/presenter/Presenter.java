package presenter;

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
     * Show some notice to the user.
     * @param s Some notice
     */
    static public void showNotice(String s) {
        showInstruction("\033[1;33m"+s+"\033[0m");
    }

    /**
     * Show some error to the user.
     * @param s Some error
     */
    static public void showError(String s) {
        showInstruction("\033[1;31m"+s+"\033[0m");
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
        System.out.println("\033[1;36m"+title+"\033[0m");
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
        System.out.println("\033[1;36m"+title+"\033[0m");
        showMenu(menu);
    }
}
