public class FriendRequestMessage extends Message {
    public FriendRequestMessage(String fromID, String toID) {
        super(fromID, toID, fromID + " has sent you a friend request!");
    }
}
