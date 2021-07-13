import java.util.ArrayList;

public class UserManager{
    /**
     * Stores users (ArrayList)
     * Create an User object
     * Duplicate (Registered) User checker
     */

    private ArrayList<User> users;

    public boolean usedUsername(User username){
        return this.users.contains(username);
    }

    // I decided to exclude guest since the data of a guest user is temporary and therefore should not be added
    //to the list
    public User createUser(String username, String password, String type){
        if (type.equals("Regular")){
            User rUser = new RegularUser(username,password);
            this.users.add(rUser);
            return rUser;
        }
        else if (type.equals("Admin")){
            User aUser = new AdminUser(username,password);
            this.users.add(aUser);
            return aUser;
        }
        return null;
    }
}
