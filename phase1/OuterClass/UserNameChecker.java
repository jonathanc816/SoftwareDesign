public class UserNameChecker implements ValidationChecker{
    @Override
    public boolean check(String s) {
        return !UserManager.isUserExist(s);
    }

    @Override
    public String warning() {
        return "User name already existed, please try another one";
    }
}