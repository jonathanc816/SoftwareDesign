package controller.inputChecker;

public interface ValidationChecker {
    boolean check(String s);
    String warning();
}
