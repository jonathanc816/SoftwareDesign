package entity;

import java.io.Serializable;

/**
 * Entity c
 */
public class Message implements Serializable {
    private final String fromID;
    private String toID;
    private String content;

    /**
     * Constructor for entity.Message
     * @param fromID Who the message is from
     * @param toID Who the message is to
     * @param content Content of the message
     */
    public Message(String fromID, String toID, String content) {
        this.fromID = fromID;
        this.toID = toID;
        this.content = content;
    }

    /**
     * @return content of message
     */
    public String getContent(){return this.content;}

    /**
     * @return userid of message sender
     */
    public String getFromID(){return this.fromID;}

    /**
     * @return userid of message receiver
     */
    public String getToID(){return this.toID;}

    /**
     * @param newContent content to set message to
     * set the content of the message
     */
    public void setContent(String newContent){this.content = newContent;}

    /**
     * @param newToID the new ID of the message
     */
    public void setToID(String newToID){this.toID = newToID;}
}
