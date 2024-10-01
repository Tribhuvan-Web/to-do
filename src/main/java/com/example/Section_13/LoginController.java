package com.example.Section_13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SuppressWarnings("unused")
@Controller // => we are telling spring to manage the component
@SessionAttributes("name") // => this would ensure the session attributes use it in the model application
public class LoginController {

    private AuthenticationService authenticationService;

    // Using constructor injection
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            return "welcome";
        }

        model.put("errorMessage", "Invalid credential ! Please try again");
        return "login";
    }
}
