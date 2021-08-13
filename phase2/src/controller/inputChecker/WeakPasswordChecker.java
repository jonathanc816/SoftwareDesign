package controller.inputChecker;

public class WeakPasswordChecker implements ValidationChecker{
    @Override
    public boolean check(String s) {
        return !(s.length() < 4);
    }

    @Override
    public String warning() {
        return "This password is too weak, please enter a password of length at least 4";
    }
}
