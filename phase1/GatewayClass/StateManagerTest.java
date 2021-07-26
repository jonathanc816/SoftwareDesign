import java.io.*;

public class StateManagerTest {
    public static void main(String [] args) {
        UserManager save_test = new UserManager();
        save_test.addUser(save_test.createUser("bobby", "Pokemon", false));
        try {
            FileOutputStream fileOut = new FileOutputStream("Files/UserManager.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(save_test);
            out.close();
            fileOut.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }

        UserManager e = null;
        try {
            FileInputStream fileIn = new FileInputStream("Files/UserManager.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (UserManager) in.readObject();
            in.close();
            fileIn.close();

        }
        catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        assert e != null;
        System.out.println(e.login("bobby", "Pokemon"));
    }
}
