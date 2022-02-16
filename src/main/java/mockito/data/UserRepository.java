package mockito.data;

import mockito.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<String, User>();

    public UserRepository() {
        //Regular
        users.put("matt", User.createRegularUser("matt", "1234"));
        users.put("frank", User.createRegularUser("frank", "1234"));

        //Admin
        users.put("admin", User.createAdminUser("admin", "1234"));
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public List<User> findAll() {
        return new LinkedList<>(users.values());
    }
}
