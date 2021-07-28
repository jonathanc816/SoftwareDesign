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

    public void addUser(User user) {
        this.userList.put(user.getUsername(), user);
        this.currentUser = user;
    }

    public void addUsers(List<User> users) {
        for (User x : users) {
            this.userList.put(x.getUsername(), x);
        }
    }

    public User createUser(String name, String password) { // change this later to encompass all
        password = this.hasher(password);
        return new User(name, password);
    }

    public User createAdminUser(String name, String password) {
        return new AdminUser(name, hasher(password));
    }

    public void deleteUser(String name) {
        this.userList.remove(name);
    }

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

    public GuestUser createGuestUser() {
        return new GuestUser("guest", hasher("guest"));
    }

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

