package mockito.service;

import mockito.User;
import mockito.data.UserRepository;

public class AuthenticationService {
    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user.getPassword().equals(password);
    }
}
