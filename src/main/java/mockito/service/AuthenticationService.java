package mockito.service;

import mockito.User;
import mockito.data.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

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
