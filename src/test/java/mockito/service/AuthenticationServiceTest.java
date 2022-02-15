package mockito.service;

import mockito.data.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class AuthenticationServiceTest {

    private AuthenticationService authenticationService; //SUT (System Under Test)

    private UserRepository userRepository; //mock

    @BeforeEach
    void setUp() {
        this.userRepository = Mockito.mock(UserRepository.class);
        this.authenticationService = new AuthenticationService(this.userRepository);
    }

    //similar to @Ignore in junit4
    //To not run a test
    @Disabled
    @Test
    public void testAuthenticate() {
        //arrange
        Mockito.when(this.userRepository.findByUsername(anyString())).thenThrow(new IllegalArgumentException());

        //act
        this.authenticationService.authenticate("harry", "1234");

        //assert

    }
}