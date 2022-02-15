package mockito.web;

import mockito.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class LoginControllerTest {

    private LoginController loginController; //SUT (System Under Test)
    private AuthenticationService service; //mock

    @BeforeEach
    void setUp() {
        //Everytime we test, we get a brand new LoginController and mock
        this.service = Mockito.mock(AuthenticationService.class);
        this.loginController = new LoginController(this.service);
    }

    @Test
    void testService_validUsernameAndPassword_logsInUser() {
        //arrange
        //When user successfully logged in
        Mockito.when(this.service.authenticate(anyString(), anyString())).thenReturn(true);

        //act
        String viewPath = loginController.service("saua", "1234");

        //assert
        assertNotNull(viewPath);
        assertEquals("/home", viewPath);
    }
}