import java.util.HashMap;

public class UserService {
    private HashMap<String,User> users=new HashMap<>();

    public void addUser(String userId, String name, double funds) {
        users.put(userId, new User(userId, name , funds));
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
