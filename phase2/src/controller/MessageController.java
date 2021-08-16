package controller;

import entity.Message;
import entity.User;
import presenter.Presenter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Message controller for Managers.
 */
public class MessageController extends ManagerControl {
    static String friendRequest = "Do you want to be friends?";

    /**
     * Shows a users mailbox and allows them to interact with the mail.
     */
    static public void mailbox() {
        User user = LocalUserManager.getCurrentUser();
        viewMails(user, "mailbox");
    }

    /**
     * Show inbox for reports
     */
    static public void reportBox() {
        viewMails(LocalUserManager.adminInbox, "report box");
    }

    /**
     * @param user user to view the mails of
     * @param name name of current user
     * views the mail of a certain user
     */
    static public void viewMails(User user, String name) {
        boolean back = false;
        while (!back) {
            ArrayList<Message> messages = LocalMessageManager.getMessages(user.getInbox());

            if (messages.size() == 0) {
                Presenter.showNotice("Your "+name+" is empty.");
                back = true;
            }
            else {
                ArrayList<String> fromIdList = new ArrayList<>();
                for (Message message : messages) {
                    fromIdList.add("A message from: "+message.getFromID());
                }
                fromIdList.add("Clean "+name);
                fromIdList.add("Back");

                Presenter.showMenu(fromIdList, "You have "+messages.size()+" messages in your "+name+", " +
                        "select number to see detail");
                int userChoice = GameController.getUserNum(messages.size()+2);
                if (userChoice == messages.size()+1) {
                    user.cleanInbox();
                    Presenter.showNotice("You have cleaned your "+name+" successfully!");
                    back = true;
                }
                else if (userChoice == messages.size()+2) {
                    back = true;
                }
                else {
                    seeMessage(messages.get(userChoice-1));
                }
            }
        }
    }

    /**
     * Shows the user a specific message in detail, and allows for response fields/friend request responses.
     * @param message the message to show
     */
    static public void seeMessage(Message message) {
        Presenter.showInstruction(
                "From: "+message.getFromID()+"  To: "+message.getToID()+"\nContent: "+message.getContent()+"\n");
        if (message.getContent().equals(friendRequest)) {
            boolean UserInput = GameController.getUserYesOrNo(
                    "Enter 'y' to accept this friend request or 'n' to ignore");
            if (UserInput) {
                User fromUser = LocalUserManager.getUserByName(message.getFromID());
                User toUser = LocalUserManager.getUserByName(message.getToID());
                if (!fromUser.getFriendList().contains(toUser.getUsername())) {
                    fromUser.addFriendName(toUser.getUsername());
                    toUser.addFriendName(fromUser.getUsername());
                }
                Presenter.showNotice("You are friends with "+message.getFromID()+" now.\n");
            }
            else {
                Presenter.showNotice("You have ignored this friend request.\n");
            }
        }
        else {
            GameController.getUserString("Enter any letter to go back");
        }
    }

    /**
     * Create a message to another user based on user inputs.
     */
    static public void createMessage() {
        String fromId = LocalUserManager.getCurrentUser().getUsername();
        Presenter.showInstruction(LocalMessageManager.getTemplateInfo()+"\n");
        String toId = GameController.getUserString("Please enter the username of the addressee...");
        String content = GameController.getUserString("Please enter the content of the message...");

        boolean userInput = GameController.getUserYesOrNo("Enter 'y' to send it or 'n' to go back");
        if (userInput) {
            int messageID = LocalMessageManager.createMessage(fromId, toId, content);

            if (LocalUserManager.isUserExist(toId)) {
                Objects.requireNonNull(LocalUserManager.getUserByName(toId)).addInboxId(messageID);
                Presenter.showNotice("Your lovely pet has sent your message to "+toId+". Great!\n");
            }
            else {
                Presenter.showNotice("Unfortunately, Your pet couldn't find the addressee. Please try again.\n");
            }
        }
    }

    /**
     * Create a report based on user inputs.
     */
    static public void createReport() {
        String fromId = LocalUserManager.getCurrentUser().getUsername();
        String content = GameController.getUserString("Please enter your report to all admin users...");
        int messageID = LocalMessageManager.createMessage(fromId, "All Admin Users", content);
        LocalUserManager.adminInbox.addInboxId(messageID);
        Presenter.showNotice("All admin users have received you issue. Thanks for your report!\n");
    }

    /**
     * Create a friend request to send to another user.
     * @param fromId ID of the user to send from
     * @param toId ID of the user to send to
     */
    static public void createFriendRequest(String fromId, String toId) {
        int messageID = LocalMessageManager.createMessage(fromId, toId, friendRequest);
        Objects.requireNonNull(LocalUserManager.getUserByName(toId)).addInboxId(messageID);
    }
}
