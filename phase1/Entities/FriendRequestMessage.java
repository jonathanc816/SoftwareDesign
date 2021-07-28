public class FriendRequestMessage extends Message {
    /**
     * @param fromID user to send from
     * @param toID user to send to
     */
    public FriendRequestMessage(String fromID, String toID) {
        super(fromID, toID, fromID + " has sent you a friend request!");
    }
}
