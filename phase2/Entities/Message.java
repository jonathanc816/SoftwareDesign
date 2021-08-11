import java.io.Serializable;

public class Message implements Serializable {
    private final String fromID;
    private String toID;
    private String content;

    /**
     * Constructor for Message
     * @param fromID Who the message is from
     * @param toID Who the message is to
     * @param content Content of the message
     */
    public Message(String fromID, String toID, String content) {
        this.fromID = fromID;
        this.toID = toID;
        this.content = content;
    }
    public String getContent(){return this.content;}

    public String getFromID(){return this.fromID;}

    public String getToID(){return this.toID;}

    public void setContent(String newContent){this.content = newContent;}

    public void setToID(String newToID){this.toID = newToID;}
}
