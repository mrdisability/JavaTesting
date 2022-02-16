package mockito.service;

import mockito.User;
import mockito.data.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class UserLookupService {

    private UserRepository userRepository;

    public UserLookupService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<User> getRegularUsers() {
        return getUsersByUserType(User.UserType.REGULAR_USER);
    }

    public Set<User> getAdminUsers() {
        return getUsersByUserType(User.UserType.ADMIN_USER);
    }

    public Set<User> getUsersByUserType(User.UserType userType) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.isLive() && user.getUserType() == userType)
                .collect(Collectors.toSet());
    }

}
