package entity;

/**
 * Subclass of user that represents an administrator
 */
public class AdminUser extends User{
    /**
     * @param username username for adminuser
     * @param password password for adminuser
     */
    public AdminUser(String username, String password) {
        super(username, password);
    }
}
