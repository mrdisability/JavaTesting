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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        // arrange
        List<User> userList = new LinkedList<>();
        userList.add(User.createRegularUser("sam", "password"));
        userList.add(User.createRegularUser("john", "password"));
        userList.add(User.createAdminUser("admin", "password"));

        Mockito.when(userRepository.findAll()).thenReturn(userList);

        // act
        Set<User> actualUsers = userLookupService.getRegularUsers();

        // assert - general collection
        // 2 options can use junit or hamcrest assertions
        assertNotNull(actualUsers);
        assertEquals(actualUsers.size(), 2);

        // check user 1
        User actualUser1 = userList.get(0);
        assertNotNull(actualUser1);
        assertEquals(actualUser1.getUserType(), User.UserType.REGULAR_USER);
        assertEquals(actualUser1.getUsername(), "sam");
        assertEquals(actualUser1.getPassword(), "password");

        User actualUser2 = userList.get(1);
        assertNotNull(actualUser2);
        assertEquals(actualUser2.getUserType(), User.UserType.REGULAR_USER);
        assertEquals(actualUser2.getUsername(), "john");
        assertEquals(actualUser2.getPassword(), "password");
    }

    @Test
    void getAdminUsers() {
    }
}