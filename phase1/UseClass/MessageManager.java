/**
 *    Stores messages (list)
 *    Get message based on id
 *    Send messages between users (add message to users mailbox)
 *    Add to messages (Message)
 */
public class MessageManager{
    private List<Message> messageList;

    public void storeMessage(List<Message> messagelist){
        this.messageList = messagelist;
    }

    public Message getMessage(String id){
        for (int i=0;i<messageList.size();i++) {
            Message currMessage = messageList.get(i)
            if (currMessage.getMessageId() == id) {
                return currMessage;
            }
        }
    }

    public void addMessage(Message message){
        if(this.messageList != null) {
            this.messageList.add(message);
        }else{
            this.messageList = new ArrayList<>();
            this.messageList.add(message);
        }
    }
}