public class UserNameChecker extends ManagerControl implements ValidationChecker{
    @Override
    public boolean check(String s) {
        return !LocalUserManager.isUserExist(s);
    }

    @Override
    public String warning() {
        return "User name already existed, please try another one";
    }
}