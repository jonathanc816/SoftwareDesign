package controller.inputChecker;

import controller.ManagerControl;

/**
 * Check if user is a valid user
 */
public class ValidUserChecker extends ManagerControl implements ValidationChecker{
    /**
     * Return true iff username exist
     * @param s String to check
     * @return passing value of check
     */
    @Override
    public boolean check(String s) {
        return LocalUserManager.isUserExist(s);
    }

    /**
     * Return a warning.
     * @return A warning
     */
    @Override
    public String warning() {
        return "This user does not exist, please try another one";
    }
}