package controller.inputChecker;

public class NoneEmptyChecker implements ValidationChecker{
    @Override
    public boolean check(String s) {
        return !s.isEmpty();
    }

    @Override
    public String warning() {
        return "Invalid empty string here, please enter some content.";
    }
}
