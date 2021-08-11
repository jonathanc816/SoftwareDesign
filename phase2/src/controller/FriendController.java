package controller;

import entity.Pet;
import entity.User;
import presenter.Presenter;

import java.util.ArrayList;

public class FriendController extends ManagerControl {

    /**
     * Shows menu for friends and does some action based on the result of the users input.
     */
    static public void friendMenu() {
        while(true) {
            if (LocalUserManager.isCurrentUserGuest()) {
                Presenter.showMenu(new String[] {}, "Guest users can't add friends. Press enter to return.");
                String userChoice = GameController.getUserString();
                return;
            }
            Presenter.showMenu(new String[]{"Friend list", "Add friend", "Back"}, "This is your friend menu, you can:");
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

    /**
     * Show a list of the current users friends and interact with those friends.
     */
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
                Presenter.showMenu(friends, "You have "+friendNum+" friend[s], enter a number to see visit them.");
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
                        Presenter.showInstruction("Oh no. Your friend has made their pet private." +
                                "\nPress any key to go back");
                        GameController.getUserString();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Add a friend from a users input and verify that input.
     */
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
