import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

public class UserManager implements Serializable {
    private final HashMap<String, User> userList = new HashMap<>();
    private User currentUser = null;

    public User getCurrentUser() { return currentUser; }

    public void setCurrentUser(User new_user) {
        currentUser = new_user;
    }

    public boolean isUserExist(String name) {
        return this.userList.containsKey(name);
    }

    public boolean isCurrentUserGuest() {
        return (this.currentUser instanceof GuestUser);
    }

    public boolean isCurrentUserAdmin() {
        return (this.currentUser instanceof AdminUser);
    }

    public User getUserByName(String name) {
        return this.userList.get(name);
    }

    /**
     * Adds user to userlist
     * @param user user to add
     */
    public void addUser(User user) {
        this.userList.put(user.getUsername(), user);
        this.currentUser = user;
    }

    /**
     * adds multiple users to userlist.
     * @param users list of users
     */
    public void addUsers(List<User> users) {
        for (User x : users) {
            this.userList.put(x.getUsername(), x);
        }
    }

    /**
     * Hashes the password and creates/returns a entity.User object
     * @param name Unique username
     * @param password Password value
     * @return a user object
     */
    public User createUser(String name, String password) { // change this later to encompass all
        password = this.hasher(password);
        return new User(name, password);
    }

    /**
     * Hashes the password and creates/returns an entity.AdminUser object
     * @param name Unique username
     * @param password Password value
     * @return a user object
     */
    public User createAdminUser(String name, String password) {
        return new AdminUser(name, hasher(password));
    }

    /**
     * Creates a guest user account with default values.
     * @return a user object
     */
    public GuestUser createGuestUser() {
        return new GuestUser("guest", hasher("guest"));
    }

    public void deleteUser(String name) {
        this.userList.remove(name);
    }

    /**
     * Hashes input password and checks against stored hashed passwords.
     * @param username username to login with
     * @param password password to login with
     * @return boolean value for correct login
     */
    public boolean login(String username, String password) {
        User user = this.getUserByName(username);
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


    /**
     * Takes in a string and converts to bytes and hashes them with SHA-256, converts them back into
     * readable strings to use as hashed password values.
     * @param toHash String to hash
     * @return hashed version of password
     */
    private String hasher(String toHash) { // hashes the values that the user inputs as their password
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

