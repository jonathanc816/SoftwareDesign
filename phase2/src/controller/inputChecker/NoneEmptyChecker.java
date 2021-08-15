package controller.inputChecker;

/**
 * Validation checking class that checks if the string is empty
 */
public class NoneEmptyChecker implements ValidationChecker{
    /**
     * @param s string to check
     * @return boolean value if the string is empty
     */
    @Override
    public boolean check(String s) {
        return !s.isEmpty();
    }

    /**
     * @return Warning that states empty string
     */
    @Override
    public String warning() {
        return "Invalid empty string here, please enter some content.";
    }
}
