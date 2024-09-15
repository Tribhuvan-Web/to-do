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

    private Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * When we want to pass anything from the controller to jsp we'll use the model
     * => Modelmap
     * 
     * View resolver can map specific JSP name and get the exact view name
     * public String login(@RequestParam String name, ModelMap model) {
     * model.put("name", name);
     * logger.debug(name);
     * logger.warn(name);
     * logger.info(name);
     * System.out.println("Request param is " + name); // => Not recommended for
     * production
     * return "login";
     * }
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            /*
             * Authentication logic
             * name - reyansh password - dummy
             * if this is same then you will redirected to the page if not then to the login
             * page
             * 
             */
            return "welcome";
        }

        model.put("errorMessage", "Invalid credential ! Please try again");
        return "login";
    }
}
