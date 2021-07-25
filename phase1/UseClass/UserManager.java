import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

public class UserManager implements Serializable {
    static HashMap<String, User> userList = new HashMap<>();
    static User currentUser = null;

    public static boolean isUserExist(String name) {
        return userList.containsKey(name);
    }

    public static User getUserByName(String name) {
        return userList.get(name);
    }

    public static void addUser(User user) {
        userList.put(user.getUsername(), user);
        currentUser = user;
    }

    public static void addUsers(List<User> users) {
        for (User x : users) {
            userList.put(x.getUsername(), x);
        }
    }

    public static User createUser(String name, String password, boolean isAdmin) {
        password = hasher(password);
        return new User(name, password, isAdmin);
    }

    public static boolean login(String username, String password) {
        User user = getUserByName(username);
        if (!isUserExist(username)) {
            return false;
        }
        assert user != null;
        if (user.getPassword().equals(hasher(password))) {
            currentUser = user;
            return true;
        }
        return false;
    }

    private static String hasher(String toHash) { // hashes the values that the user inputs as their password
        try {
            final byte[] hash = MessageDigest.getInstance("SHA-256").digest(toHash.getBytes(StandardCharsets.UTF_8));
            final StringBuilder new_str = new StringBuilder(hash.length);
            for (byte hashVal : hash)
                new_str.append(Integer.toHexString(255 & hashVal));
            return new_str.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/**
 *  Will put the read/write method in the gateway classes later --Yupeng
 */


//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.HashMap;
//public class UserManager{
//
//    private HashMap<String, String> userAcc;
//
//    public boolean registerUser(String username, String pw) throws IOException {
//        if (duplicatedUser(username)){
//            userAcc.put(username, pw);
//            FileWriter registeredUsers = new FileWriter("registeredUsers.csv");
//            registeredUsers.write(username + "," + pw + "\r\n");
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
//
//    public boolean duplicatedUser(String username) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new FileInputStream("registeredUsers.csv"));
//        String[] current = scanner.nextLine().split(",");
//        while (scanner.hasNextLine()){
//           if (current[0].equals(username)){
//               return true;
//           }
//        }
//        scanner.close();
//        return false;
//    }
//
//    // I decided to exclude guest since the data of a guest user is temporary and therefore should not be stored
//
//    public User createUserObj(String username, String password, String type) throws IOException {
//        FileWriter userInfo = new FileWriter("userInfo.csv");
//        if (type.equals("Regular")){
//            RegularUser rUser = new RegularUser(username, password);
//            userInfo.write(username + "," + type + "," + rUser.getPetId() + "\r\n");
//            return rUser;
//        }
//
//        else if (type.equals("Admin")){
//            AdminUser aUser = new AdminUser(username, password);
//            userInfo.write(username + "," + type + "," + aUser.getPetId() + "\r\n");
//            return aUser;
//        }
//        return null;
//    }
//
//    public String[] retriveUserInfo(String username) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new FileInputStream("userInfo.csv"));
//        String[] currLine;
//        while (scanner.hasNextLine()){
//            currLine = scanner.nextLine().split(","); // Advances this scanner past the current line and returns the input that was skipped.
//            if (currLine[0].equals(username)){
//                return currLine;
//            }
//        }
//        scanner.close();
//        return null;
//    }
//
//}
//
//
//
