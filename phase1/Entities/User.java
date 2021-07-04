import java.util.Hashtable;
import java.util.List;
public class User {
    private String username;
    private List inbox;
    private int food;
    private String type;
    private Hashtable password;

    User(String username, Hashtable password, String usertype){
        this.username = username;
        this.type = usertype;
    }

}
