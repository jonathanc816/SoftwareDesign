public class Message {
    private final String fromID;
    private String toID;
    private String content;

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
