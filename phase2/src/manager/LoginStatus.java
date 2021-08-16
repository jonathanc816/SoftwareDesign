package manager;

/**
 * Class to represent login status
 */
public class LoginStatus {
    /** A boolean value determining login success */
    public boolean success;
    /** A string containing login information */
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
