import java.util.ArrayList;
import java.util.Objects;

public class MessageController extends ManagerControl {
    static String friendRequest = "Can we make friends?";

    static public void mailbox() {
        boolean back = false;
        while (!back) {
            User user = LocalUserManager.getCurrentUser();

            ArrayList<Message> messages = LocalMessageManager.getMessages(user.getInbox());

            if (messages.size() == 0) {
                Presenter.showInstruction("Your mailbox is empty, enter any letter to go back");
                GameController.getUserString();
                back = true;
            }
            else {
                ArrayList<String> fromIdList = new ArrayList<>();
                for (Message message : messages) {
                    fromIdList.add("A message from: "+message.getFromID());
                }
                fromIdList.add("Back");

                Presenter.showMenu(fromIdList, "You have "+messages.size()+" messages in your mailbox, " +
                        "select number to see detail");
                int userChoice = GameController.getUserNum(messages.size()+1);
                if (userChoice == messages.size()+1) {
                    back = true;
                }
                else {
                    seeMessage(messages.get(userChoice-1));
                }
            }
        }
    }

    static public void seeMessage(Message message) {
        Presenter.showInstruction(
                "From: "+message.getFromID()+"  To: "+message.getToID()+"\nContent: "+message.getContent()+"\n");
        if (message.getContent().equals(friendRequest)) {
            boolean UserInput = GameController.getUserYesOrNo(
                    "Enter 'y' to accept this friend request or 'n' to ignore");
            if (UserInput) {
                User fromUser = LocalUserManager.getUserByName(message.getFromID());
                User toUser = LocalUserManager.getUserByName(message.getToID());
                fromUser.addFriendName(toUser.getUsername());
                toUser.addFriendName(fromUser.getUsername());
                GameController.getUserString("You are friends with "+message.getFromID()+
                        " now. Enter any letter to go back");
            }
            else {
                GameController.getUserString("You have ignored this friend request, " +
                        "Enter any letter to go back");
            }
        }
        else {
            GameController.getUserString("Enter any letter to go back");
        }
    }

    static public void createMessage() {
        String fromId = LocalUserManager.getCurrentUser().getUsername();
        Presenter.showInstruction(LocalMessageManager.getTemplateInfo()+"\n");
        String toId = GameController.getUserString("Please enter the username of the addressee...");
        String content = GameController.getUserString("Please enter the content of the message...");
        int messageID = LocalMessageManager.createMessage(fromId, toId, content);

        if (LocalUserManager.isUserExist(toId)) {
            Objects.requireNonNull(LocalUserManager.getUserByName(toId)).addInboxId(messageID);
            Presenter.showInstruction("Your lovely pet has sent your message to "+toId+". Great!");
        }
        else {
            Presenter.showInstruction("Unfortunately, Your pet couldn't find the addressee. Please try again.");
        }
    }

    static public void createFriendRequest(String fromId, String toId) {
        int messageID = LocalMessageManager.createMessage(fromId, toId, friendRequest);
        Objects.requireNonNull(LocalUserManager.getUserByName(toId)).addInboxId(messageID);
    }
}
