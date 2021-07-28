import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (Message)
 */
public class MessageManager extends TemplateInfo{

    public Integer messageID = 0;
    public HashMap<Integer, Message> messageDict = new HashMap<>();

    public MessageManager(){
        this.setTemplateInfo("You are creating a message.");
    }

    public int createMessage(String fromName, String toName, String content) {
        Message message = new Message(fromName, toName, content);
        int thisMessageID = messageID;
        addMessage(message);
        return thisMessageID;
    }

    public void addMessage(Message newMessage){
        messageDict.put(messageID, newMessage);
        messageID += 1;
    }

    public Message getMessage(int messageID) {
        return messageDict.get(messageID);
    }

    public ArrayList<Message> getMessages(ArrayList<Integer> messageIds) {
        ArrayList<Message> messages = new ArrayList<>();
        for (int id : messageIds) {
            messages.add(getMessage(id));
        }
        return messages;
    }
}