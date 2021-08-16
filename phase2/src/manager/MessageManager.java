package manager;

import entity.Message;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (entity.Message)
 */
public class MessageManager extends TemplateInfo {
    /** The ID attached to the Message object to be retrieved */
    public Integer messageID = 0;
    /** A hashmap that maps the message ID to the Message object */
    public HashMap<Integer, Message> messageDict = new HashMap<>();

    public MessageManager(){
        this.setTemplateInfo("You are creating a message.");
    }

    /**
     * Provides a new message object.
     * @param fromName String of sending user
     * @param toName String of receiving user
     * @param content Content of message
     * @return A message object
     */
    public int createMessage(String fromName, String toName, String content) {
        Message message = new Message(fromName, toName, content);
        int thisMessageID = messageID;
        addMessage(message);
        return thisMessageID;
    }

    /**
     * Adds the given message to the manager.MessageManager map.
     * @param newMessage Adds message to manager.MessageManager map.
     */
    public void addMessage(Message newMessage){
        messageDict.put(messageID, newMessage);
        messageID += 1;
    }

    /**
     * @param messageID get the message from message id
     * @return the message
     */
    public Message getMessage(int messageID) {
        return messageDict.get(messageID);
    }

    /**
     * Get all the messages in messageIds and return a list of them.
     * @param messageIds ArrayList of messageIds
     * @return Arraylist of messages
     */
    public ArrayList<Message> getMessages(ArrayList<Integer> messageIds) {
        ArrayList<Message> messages = new ArrayList<>();
        for (int id : messageIds) {
            messages.add(getMessage(id));
        }
        return messages;
    }
}