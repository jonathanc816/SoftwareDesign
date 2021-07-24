public class Presenter {
    static public void showInstruction(String s) {
        System.out.println(s);
    }

    static public void showMenu(String[] menu) {
        int i = 1;
        for (String line : menu){
            System.out.println(i+". "+line);
            i ++;
        }
    }

    static public void showMenu(String[] menu, String title) {
        System.out.println(title);
        int i = 1;
        for (String line : menu){
            System.out.println(i+". "+line);
            i ++;
        }
    }
}
