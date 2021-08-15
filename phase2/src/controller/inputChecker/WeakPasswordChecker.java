package controller.inputChecker;

/**
 * ValidationChecker that checks if password is weak
 */
public class WeakPasswordChecker implements ValidationChecker{
    /**
     * @param s Password to check
     * @return boolean value that checks if the requirements are satisfied.
     */
    @Override
    public boolean check(String s) {
        boolean uppercase = false;
        boolean has_symbol = false;
        boolean has_digit = false;
        String check_symbols = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (check_symbols.indexOf(c) != -1) {
                has_symbol = true;
            }
            if (Character.isUpperCase(c)) {
                uppercase = true;
            }
            if (Character.isDigit(c)) {
                has_digit = true;
            }
        }
        return !(s.length() < 6) && has_symbol && uppercase && has_digit;
    }

    /**
     * @return Warning of the password not fulfilling requirements.
     */
    @Override
    public String warning() {
        return "This password is too weak, please enter a password of length at least 6 with a symbol, uppercase character, and a digit.";
    }
}
