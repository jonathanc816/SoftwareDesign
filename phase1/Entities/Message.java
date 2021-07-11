public class Message {
    private final User fromID;
    private User toID;
    private String content;

    public Message(User fromID, User toID, String content) {
        this.fromID = fromID;
        this.toID = toID;
        this.content = content;
    }
    public String getContent(){return this.content;}

    public String getFromID(){return this.fromID.getUsername();}

    public String getToID(){return this.toID.getUsername();}

    public void setContent(String newContent){this.content = newContent;}

    public void setToID(User newToID){this.toID = newToID;}
}
