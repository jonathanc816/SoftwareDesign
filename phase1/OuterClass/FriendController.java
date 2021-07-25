import java.util.ArrayList;

public class FriendController {
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
        ArrayList<String> friends = UserManager.currentUser.getFriendList();
        int friendNum = friends.size();
        friends.add("Back");

        while (true) {
            if (friendNum == 0) {
                GameController.getUserString("You have no friend now, press any key to go back.");
                return;
            }
            else {
                Presenter.showMenu(friends, "You have "+friendNum+" friends, enter number to see more.");
                int userChoice = GameController.getUserNum(friendNum + 1);
                if (userChoice == friendNum + 1) {
                    return;
                }
                else {
                    User friend = UserManager.getUserByName(friends.get(userChoice-1));
                    Pet friendPet = PetManager.findPet(friend.getPetId());
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
        if (UserManager.currentUser.getFriendList().contains(friendName)) {
            GameController.getUserString("You have already add "+friendName+", enter any key to go back");
        }
        else if (friendName.equals(UserManager.currentUser.getUsername())) {
            GameController.getUserString("Can't add yourself, enter any key to go back");
        }
        else if (UserManager.isUserExist(friendName)) {
            MessageController.createFriendRequest(UserManager.currentUser.getUsername(), friendName);
            GameController.getUserString(friendName+" has received your friend request. " +
                    "\nwait for acceptance, enter any key to go back");
        }
        else {
            GameController.getUserString("User not exist, enter any key to go back");
        }
    }
}
