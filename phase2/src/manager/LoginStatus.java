package manager;

public class LoginStatus {
    public boolean success;
    public String information;

    public LoginStatus(boolean success, String information) {
        this.success = success;
        this.information = information;
    }
}
