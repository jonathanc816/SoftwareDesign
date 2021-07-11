public class FriendRequestMessage extends Message {
    public FriendRequestMessage(User fromID, User toID) {
        super(fromID, toID, fromID.getUsername() + " has sent you a friend request!");
    }
}
