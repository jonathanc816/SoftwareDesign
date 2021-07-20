import java.util.ArrayList;

public class User {
    private String username;
    private String password; // Can input it as a hashed string and have a hashing function in the UserManager class
    private int petId; // CamelCase convention
    private int food;
    private final ArrayList<Integer> inbox; // setting these to final because we never will reassign them
    private final ArrayList<Integer> reminderList;
    private final ArrayList<String> friendList; //temporary changed to String, it was Integer before



    public User(String username, String password){
        this.username = username;
        this.password = password;
        petId += 1;
        this.food = 0;
        this.inbox = new ArrayList<Integer>();
        this.reminderList = new ArrayList<Integer>();
        this.friendList = new ArrayList<String>();
    }

    public String getUsername() { return this.username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return this.password; }

    public void setPassword(String new_pass) { this.password = new_pass; } // should only pass in hashed passwords

    public int getPetId(){ return petId; }

    public int getFood() { return this.food; }

    public void setFood(int food) { this.food = food; }

    public ArrayList<Integer> getInbox(){ return this.inbox; }

    public ArrayList<Integer> getReminders() { return this.reminderList; }

    public ArrayList<String> getFriendList() { return this.friendList; }

}
