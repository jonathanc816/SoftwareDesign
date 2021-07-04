import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
public class User {
    private String username;
    private List<Integer> inbox;
    private int food;
    private Hashtable password;
    private static int pet_id;

    User(String username, Hashtable password){
        this.username = username;
        this.inbox = new ArrayList<Integer>();
        pet_id += 1;
        this.food = 0;
    }

    public static int getPet_id(){
        return pet_id;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public List<Integer> getInbox(){
        return this.inbox;
    }

}
