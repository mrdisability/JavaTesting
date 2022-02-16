package mockito.service;

import mockito.User;
import mockito.data.UserRepository;
import mockito.service.UserLookupService;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
    void getRegularUsers_junit() {
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
    void getRegularUsers_hamcrest() {
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
        assertThat(actualUsers, Matchers.is(notNullValue()));
        assertThat(actualUsers.size(), equalTo(2));

        // Great for testing sets as it can be in any order
        // Hamcrest very readable and compress everything down unlike junit
        // Keeping production code to a minimum User.createRegularUser()
        assertThat(actualUsers, IsIterableContainingInAnyOrder.containsInAnyOrder(
                allOf(
                        Matchers.hasProperty("username", equalTo("sam")),
                        Matchers.hasProperty("password", equalTo("password"))
                ),
                allOf(
                        Matchers.hasProperty("username", equalTo("john")),
                        Matchers.hasProperty("password", equalTo("password"))
                )
        ));

        //equalTo(User.createRegularUser("john", "password"))

        // check user 1
//        User actualUser1 = actualUsers.get(0);
//        assertNotNull(actualUser1);
//        assertEquals(actualUser1.getUserType(), User.UserType.REGULAR_USER);
//        assertEquals(actualUser1.getUsername(), "sam");
//        assertEquals(actualUser1.getPassword(), "password");
//      // check user 2
//        User actualUser2 = actualUsers.get(1);
//        assertNotNull(actualUser2);
//        assertEquals(actualUser2.getUserType(), User.UserType.REGULAR_USER);
//        assertEquals(actualUser2.getUsername(), "john");
//        assertEquals(actualUser2.getPassword(), "password");
    }

    @Test
    void getAdminUsers() {
    }
}