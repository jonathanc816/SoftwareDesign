import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
public class UserManager{

    private HashMap<String, String> userAcc;

    public boolean registerUser(String username, String pw) throws IOException {
        if (duplicatedUser(username)){
            userAcc.put(username, pw);
            FileWriter registeredUsers = new FileWriter("registeredUsers.csv");
            registeredUsers.write(username + "," + pw + "\r\n");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean duplicatedUser(String username) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("registeredUsers.csv"));
        String[] current = scanner.nextLine().split(",");
        while (scanner.hasNextLine()){
           if (current[0].equals(username)){
               return true;
           }
        }
        scanner.close();
        return false;
    }

    // I decided to exclude guest since the data of a guest user is temporary and therefore should not be stored

    public User createUserObj(String username, String password, String type) throws IOException {
        FileWriter userInfo = new FileWriter("userInfo.csv");
        if (type.equals("Regular")){
            RegularUser rUser = new RegularUser(username, password);
            userInfo.write(username + "," + type + "," + rUser.getPetId() + "\r\n");
            return rUser;
        }

        else if (type.equals("Admin")){
            AdminUser aUser = new AdminUser(username, password);
            userInfo.write(username + "," + type + "," + aUser.getPetId() + "\r\n");
            return aUser;
        }
        return null;
    }

    public String[] retriveUserInfo(String username) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("userInfo.csv"));
        String[] currLine;
        while (scanner.hasNextLine()){
            currLine = scanner.nextLine().split(","); // Advances this scanner past the current line and returns the input that was skipped.
            if (currLine[0].equals(username)){
                return currLine;
            }
        }
        scanner.close();
        return null;
    }

}



