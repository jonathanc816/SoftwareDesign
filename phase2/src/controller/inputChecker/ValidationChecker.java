package controller.inputChecker;

/**
 * Interface that implements some check and returns some warning.
 */
public interface ValidationChecker {
    boolean check(String s);
    String warning();
}
