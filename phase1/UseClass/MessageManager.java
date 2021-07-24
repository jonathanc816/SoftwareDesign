import java.util.ArrayList;
import java.util.HashMap;

/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (Message)
 */
public class MessageManager{

    static private Integer messageID = 0;
    static public HashMap<Integer, Message> messageDict = new HashMap<Integer, Message>();

    static public int createMessage(String fromName, String toName, String content) {
        Message message = new Message(fromName, toName, content);
        addMessage(message);
        return messageID;
    }

    static public void addMessage(Message newMessage){
        messageDict.put(messageID, newMessage);
        messageID += 1;
    }

    static public Message getMessage(Integer messageID){return messageDict.get(messageID);}

    static public ArrayList<Message> getMessages(ArrayList<Integer> messageIds) {
        ArrayList<Message> messages = new ArrayList<Message>();
        for (int id : messageIds) {
            messages.add(getMessage(id));
        }
        return messages;
    }
}