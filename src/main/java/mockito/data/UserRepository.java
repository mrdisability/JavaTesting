package mockito.data;

import mockito.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<String, User>();

    public UserRepository() {
        users.put("matt", new User("matt", "password"));
        users.put("frank", new User("frank", "password"));
        users.put("king", new User("king", "1234"));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
