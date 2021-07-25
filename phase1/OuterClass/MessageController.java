import java.util.ArrayList;
import java.util.Objects;

public class MessageController {

    static public void mailbox() {
        boolean back = false;
        while (!back) {
            User user = UserManager.currentUser;

            ArrayList<Message> messages = MessageManager.getMessages(user.getInbox());

            if (messages.size() == 0) {
                Presenter.showInstruction("Your mailbox is empty, enter any letter to go back");
                GameController.getUserString();
                back = true;
            }
            else {
                ArrayList<String> fromIdList = new ArrayList<String>();
                for (Message message : messages) {
                    fromIdList.add("From: "+message.getFromID());
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
        GameController.getUserString("Enter any letter to go back");
    }

    static public void createMessage() {
        String fromId = UserManager.currentUser.getUsername();
        String toId = GameController.getUserString("Please enter the username of the addressee...");
        String content = GameController.getUserString("Please enter the content of the message...");
        int messageID = MessageManager.createMessage(fromId, toId, content);

        if (UserManager.isUserExist(toId)) {
            Objects.requireNonNull(UserManager.getUserByName(toId)).addInboxId(messageID);
            Presenter.showInstruction("Your lovely pet has sent your message to "+toId+". Great!");
        }
        else {
            Presenter.showInstruction("Unfortunately, Your pet couldn't find the addressee. Please try again.");
        }
    }
}
