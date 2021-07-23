import java.util.ArrayList;
import java.util.HashMap;

/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (Message)
 */
public class MessageManager{

    private static Integer messageID;
    public HashMap<Integer, String> messageDict;

    public MessageManager(){
        this.messageDict = new HashMap<>();
        messageID = 0;
    }

    public void addMessage(Message newMessage){
        this.messageDict.put(messageID, newMessage.getContent());
    }

    public String getMessage(Integer messageID){
        return messageDict.get(messageID);
    }


}