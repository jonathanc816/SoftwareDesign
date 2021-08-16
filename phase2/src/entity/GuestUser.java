package entity;

/**
 * Subclass of User that represents a guest user.
 */
public class GuestUser extends User {

    /**
     * @param username username for entity.GuestUser
     * @param password password for entity.GuestUser
     */
    public GuestUser(String username, String password) {
        super(username, password);
    }
}
