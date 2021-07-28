import java.util.ArrayList;

public class FriendController extends ManagerControl {

    static public void friendMenu() {
        while(true) {
            Presenter.showMenu(new String[]{"See friends", "Add friend", "Back"}, "This is friend menu, you can:");
            int userChoice = GameController.getUserNum(3);
                if (userChoice == 1) {
                    seeFriends();
                }
                else if (userChoice == 2) {
                    addFriends();
                }
                else {
                    return;
            }
        }
    }

    static public void seeFriends() {
        ArrayList<String> friends = new ArrayList<>(LocalUserManager.getCurrentUser().getFriendList());
        int friendNum = friends.size();
        friends.add("Back");
        while (true) {
            if (friendNum == 0) {
                GameController.getUserString("Your friends list is empty, press any key to go back.");
                return;
            }
            else {
                Presenter.showMenu(friends, "You have "+friendNum+" friends, enter number to see more.");
                int userChoice = GameController.getUserNum(friendNum + 1);
                if (userChoice == friendNum + 1) {
                    return;
                }
                else {
                    User friend = LocalUserManager.getUserByName(friends.get(userChoice-1));
                    Pet friendPet = LocalPetManager.findPet(friend.getPetId());
                    assert friendPet != null;
                    if (friendPet.getPublicity()) {
                        PetController.viewPet(friend.getPetId());
                    }
                    else {
                        Presenter.showInstruction("Oh no. Your friend has made its pet private." +
                                "\nPress any key to go back");
                        GameController.getUserString();
                        return;
                    }
                }
            }
        }
    }

    static public void addFriends() {
        String friendName = GameController.getUserString("Please enter the name of user you want to add friend...");
        if (LocalUserManager.getCurrentUser().getFriendList().contains(friendName)) {
            GameController.getUserString("You have already added "+friendName+"! enter any key to go back");
        }
        else if (friendName.equals(LocalUserManager.getCurrentUser().getUsername())) {
            GameController.getUserString("You can't add yourself! enter any key to go back");
        }
        else if (LocalUserManager.isUserExist(friendName)) {
            MessageController.createFriendRequest(LocalUserManager.getCurrentUser().getUsername(), friendName);
            GameController.getUserString(friendName+" has received your friend request. " +
                    "\nwait for acceptance, enter any key to go back");
        }
        else {
            GameController.getUserString("This user does not exist, enter any key to go back");
        }
    }
}
