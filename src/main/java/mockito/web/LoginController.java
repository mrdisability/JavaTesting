package mockito.web;

import mockito.service.AuthenticationService;

//shift command t - to create a test
public class LoginController {
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService service) {
        this.authenticationService = service;
    }

    public String service(String username, String password) {
        //send to: /home
        //send to: /login
        return authenticationService.authenticate(username, password) ? "/home" : "/login";
    }
}

//        if (authenticationService.authenticate(username, password)) {
//            return "/home";
//        }else {
//            return "/login";
//        }
