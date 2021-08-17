package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String username;
    private String password; // Can input it as a hashed string and have a hashing function in the manager.UserManager class
    private int userPetId;
    private int food;
    private final ArrayList<Integer> inbox; // setting these to final because we never will reassign them
    private final ArrayList<Integer> reminderList;
    private final ArrayList<String> friendList; //usernames of friends
    private boolean reminderPublic;


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
        this.reminderPublic = true;
    }

    /**
     * @return get the username of this user
     */
    public String getUsername() { return this.username; }

    /**
     * @param username set the username of this user
     */
    public void setUsername(String username) { this.username = username; }

    /**
     * @return get the password of this user
     */
    public String getPassword() { return this.password; }

    /**
     * @param new_pass set the password of this user
     */
    public void setPassword(String new_pass) { this.password = new_pass; } // should only pass in hashed passwords

    /**
     * @param userPetId set the petid of the user
     */
    public void setUserPetId(int userPetId) {
        this.userPetId = userPetId;
    }

    /**
     * @return get the petid of this user
     */
    public int getPetId(){ return userPetId; }

    /**
     * @return get the food status of this user
     */
    public int getFood() { return this.food; }

    /**
     * @param food set the food status of this user
     */
    public void setFood(int food) { this.food = food; }

    /**
     * @return get the inbox of this user
     */
    public ArrayList<Integer> getInbox() { return this.inbox; }

    /**
     * @param messageId add message to inbox
     */
    public void addInboxId(int messageId) {inbox.add(messageId);}

    /**
     * clear the inbox
     */
    public void cleanInbox() { inbox.clear(); }

    /**
     * @return get the reminder list of this user
     */
    public ArrayList<Integer> getReminders() { return this.reminderList; }

    /**
     * @param reminderId add a reminder to the reminder list
     */
    public void addReminderId(int reminderId) {reminderList.add(reminderId);}

    /**
     * clean the reminders list
     */
    public void cleanReminders() {
        reminderList.clear();
    }

    /**
     * @return get the users list of friends
     */
    public ArrayList<String> getFriendList() { return this.friendList; }

    /**
     * @param username add a username to friendlist
     */
    public void addFriendName(String username) {friendList.add(username);}

    /**
     * @param username remove a username from friendlist
     */
    public void removeFriendName(String username) {friendList.remove(username);}

    /**
     * @return public status of reminder
     */
    public boolean isReminderPublic() {
        return reminderPublic;
    }

    /**
     * @param reminderPublic reminder status to set
     * set the reminder status
     */
    public void setReminderPublic(boolean reminderPublic) {
        this.reminderPublic = reminderPublic;
    }
}
