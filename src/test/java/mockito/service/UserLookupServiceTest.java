package mockito.service;

import mockito.User;
import mockito.data.UserRepository;
import mockito.service.UserLookupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class UserLookupServiceTest {
    //Shift Command T: Switch back and forth between production code and test

    //@Mock
    private UserRepository userRepository;

    //@InjectMocks creates SUT with its dependencies
    //@InjectMocks
    private UserLookupService userLookupService;

    @BeforeEach
    void setUp() {
        this.userRepository = Mockito.mock(UserRepository.class);
        this.userLookupService = new UserLookupService(this.userRepository);
    }

    @Test
    void getRegularUsers() {
        //arrange
        List<User> userList = new LinkedList<>();
        userList.add(User.createRegularUser("sam", "password"));
        userList.add(User.createRegularUser("john", "password"));
        userList.add(User.createRegularUser("matt", "password"));

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        //act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        //assert
        //2 options can use junit or hamcrest assertions
    }

    @Test
    void getAdminUsers() {
    }
}