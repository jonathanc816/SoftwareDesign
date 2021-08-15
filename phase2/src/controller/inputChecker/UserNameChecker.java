package controller.inputChecker;

import controller.ManagerControl;

/**
 * Validation checking class that checks if the username is reserved
 */
public class UserNameChecker extends ManagerControl implements ValidationChecker{
    /**
     * Check if the user exists or the attempted username is guest (reserved username). Return true if
     * these two values aren't true.
     * @param s String to check
     * @return passing value of check
     */
    @Override
    public boolean check(String s) {
        return !LocalUserManager.isUserExist(s) && !s.equals("guest");
    }

    /**
     * Return a warning.
     * @return A warning
     */
    @Override
    public String warning() {
        return "This username already exists, please try another one";
    }
}