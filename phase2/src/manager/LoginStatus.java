package manager;

/**
 * Class to represent login status
 */
public class LoginStatus {
    public boolean success;
    public String information;

    /**
     * @param success boolean value of success
     * @param information information regarding login
     * initializer
     */
    public LoginStatus(boolean success, String information) {
        this.success = success;
        this.information = information;
    }
}
