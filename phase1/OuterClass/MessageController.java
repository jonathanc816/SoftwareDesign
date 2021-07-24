import java.util.ArrayList;

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
                //TODO
            }
        }
    }

    static public void seeMessage(Message message) {
        Presenter.showInstruction(
                "From: "+message.getFromID()+"  To: "+message.getToID()+"\nContent: "+message.getContent());
        GameController.getUserString("Enter any letter to go back");
    }
}
