import java.util.ArrayList;
import java.util.HashMap;

/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (Message)
 */
public class MessageManager{

    private HashMap<String, ArrayList<String>> messageDict;
    private static final HashMap<String, HashMap<String, ArrayList<String>>> allMessageDicts = new HashMap<>();

    public MessageManager(User userID){
        this.messageDict = new HashMap<>();
        allMessageDicts.put(userID.getUsername(), this.messageDict);
    }

    public void setMessageDict(User userID){
        for (int i=0; i<= userID.getFriendList().size(); i++) {
            this.messageDict.put(userID.getFriendList().get(i), new ArrayList<>());
        }
    }

    public void addMessage(Message newMessage){
        allMessageDicts.get(newMessage.getFromID()).get(newMessage.getToID()).add(newMessage.getContent());
        allMessageDicts.get(newMessage.getToID()).get(newMessage.getFromID()).add(newMessage.getContent());
    }

    public HashMap<String, ArrayList<String>> getMessagesFor(String id){
        return allMessageDicts.get(id);
    }

    public ArrayList<String> getMessageFrom(String userIDMain, String otherUserID){
        return allMessageDicts.get(userIDMain).get(otherUserID);
    }


}