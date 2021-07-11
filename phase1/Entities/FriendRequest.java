public class FriendRequest extends Message {
    public FriendRequest(User fromID, User toID, String content) {
        super(fromID, toID, fromID.getUsername() + " has sent you a friend request!");
    }
}
