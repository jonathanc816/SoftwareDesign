package controller;

import entity.Pet;
import entity.User;
import presenter.Presenter;

import java.util.ArrayList;

/**
 * Controller for friends.
 */
public class FriendController extends ManagerControl {

    /**
     * Shows menu for friends and does some action based on the result of the users input.
     */
    static public void friendMenu() {
        while(true) {
            if (LocalUserManager.isCurrentUserGuest()) {
                Presenter.showNotice("Sorry, guest users can't add friends.");
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
        while (true) {
            ArrayList<String> friends = new ArrayList<>(LocalUserManager.getCurrentUser().getFriendList());
            int friendNum = friends.size();
            friends.add("Back");
            if (friendNum == 0) {
                Presenter.showNotice("Empty friend list.\n");
                return;
            }
            else {
                Presenter.showMenu(friends, "You have "+friendNum+" friend(s), enter a number to see visit them.");
                int userChoice = GameController.getUserNum(friendNum + 1);
                if (userChoice == friendNum + 1) {
                    return;
                }
                else {
                    User friend = LocalUserManager.getUserByName(friends.get(userChoice-1));
                    seeUser(friend);
                }
            }
        }
    }

    /**
     * @param user user to see
     * Allows you to see a user
     */
    static public void seeUser(User user) {
        while (true) {
            Presenter.showMenu(new String[]{"See Pet", "View Reminders", "Delete Friend", "Go Back"},
                    "This is the homepage of "+user.getUsername()+", you could...");
            int choice = GameController.getUserNum(4);

            if (choice == 1) {
                Pet friendPet = LocalPetManager.findPet(user.getPetId());
                assert friendPet != null;
                if (friendPet.getPublicity()) {
                    PetController.viewPet(user.getPetId());
                }
                else {
                    Presenter.showNotice("Oh no. Your friend has made their pet private.\n");
                }
            }

            else if (choice == 2) {
                if (user.isReminderPublic()) {
                    ReminderController.viewFriendReminder(user);
                }
                else {
                    Presenter.showNotice("Oh no. Your friend has made their reminder private.\n");
                }
            }

            else if (choice == 3){
                deleteFriend(user.getUsername());
                return;
            }

            else {
                return;
            }
        }
    }

    /**
     * Add a friend from a users input and verify that input.
     */
    static public void addFriends() {
        String friendName = GameController.getUserString("Please enter the name of user you want to add friend...");
        if (LocalUserManager.getCurrentUser().getFriendList().contains(friendName)) {
            Presenter.showNotice("You have already added "+friendName+"!\n");
        }
        else if (friendName.equals(LocalUserManager.getCurrentUser().getUsername())) {
            Presenter.showNotice("You can't add yourself!\n");
        }
        else if (LocalUserManager.isUserExist(friendName)) {
            MessageController.createFriendRequest(LocalUserManager.getCurrentUser().getUsername(), friendName);
            Presenter.showNotice(friendName+" has received your friend request, wait for acceptance.\n");
        }
        else {
            Presenter.showNotice("User does not exist\n");
        }
    }

    static public void deleteFriend(String friendName) {
        if (!LocalUserManager.getCurrentUser().getFriendList().contains(friendName)) {
            Presenter.showNotice(friendName+" is not in your friend list"+"!\n");
        }
        else if (friendName.equals(LocalUserManager.getCurrentUser().getUsername())) {
            Presenter.showNotice("You can't delete yourself!\n");
        }

        else if (LocalUserManager.getCurrentUser().getFriendList().contains(friendName)) {
            User toUser = LocalUserManager.getUserByName(friendName);
            LocalUserManager.getCurrentUser().removeFriendName(friendName);
            toUser.removeFriendName(LocalUserManager.getCurrentUser().getUsername());
            Presenter.showNotice("You have successfully deleted "+friendName+"!\n");
        }

        else {
            Presenter.showNotice("User does not exist\n");
        }

    }
}
