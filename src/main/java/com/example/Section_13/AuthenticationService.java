package com.example.Section_13;

import org.springframework.stereotype.Service;

@Service // => Telling spring to manage the beans if !found
public class AuthenticationService {

    public boolean authenticate(String userName, String password) {

        boolean isValidUsername = userName.equalsIgnoreCase("1234");
        boolean isValidPassowrd = userName.equalsIgnoreCase("1234");

        return isValidPassowrd && isValidUsername;
    }
}
