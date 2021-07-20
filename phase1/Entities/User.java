import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class User {
    private static int globalPetId; // CamelCase convention
    private String username;
    private String password; // Can input it as a hashed string and have a hashing function in the UserManager class
    private final int userPetId;
    private int food;
    private final ArrayList<Integer> inbox; // setting these to final because we never will reassign them
    private final ArrayList<Integer> reminderList;
    private final ArrayList<Integer> friendList;



    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.userPetId = globalPetId;
        globalPetId += 1;
        this.food = 0;
        this.inbox = new ArrayList<Integer>();
        this.reminderList = new ArrayList<Integer>();
        this.friendList = new ArrayList<Integer>();
    }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }

    public void setPassword(String new_pass) { this.password = new_pass; } // should only pass in hashed passwords

    public int getPetId(){ return userPetId; }

    public int getFood() { return this.food; }

    public void setFood(int food) { this.food = food; }

    public ArrayList<Integer> getInbox(){ return this.inbox; }

    public ArrayList<Integer> getReminders() { return this.reminderList; }

    public ArrayList<Integer> getFriendList() { return this.friendList; }

}
