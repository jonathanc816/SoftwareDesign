package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class User implements Serializable {
//    private static int globalPetId; // CamelCase convention
    private String username;
    private String password; // Can input it as a hashed string and have a hashing function in the manager.UserManager class
    private int userPetId;
    private int food;
    private final ArrayList<Integer> inbox; // setting these to final because we never will reassign them
    private final ArrayList<Integer> reminderList;
    private final ArrayList<String> friendList; //usernames of friends


    /**
     * @param username username for user
     * @param password password for user
     */
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.food = 0;
        this.inbox = new ArrayList<>();
        this.reminderList = new ArrayList<>();
        this.friendList = new ArrayList<>();
    }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }

    public void setPassword(String new_pass) { this.password = new_pass; } // should only pass in hashed passwords

    public void setUserPetId(int userPetId) {
        this.userPetId = userPetId;
    }

    public int getPetId(){ return userPetId; }

    public int getFood() { return this.food; }

    public void setFood(int food) { this.food = food; }

    public ArrayList<Integer> getInbox() { return this.inbox; }

    public void addInboxId(int messageId) {inbox.add(messageId);}

    public ArrayList<Integer> getReminders() { return this.reminderList; }

    public void addReminderId(int reminderId) {reminderList.add(reminderId);}

    public ArrayList<String> getFriendList() { return this.friendList; }

    public void addFriendName(String username) {friendList.add(username);}

}
