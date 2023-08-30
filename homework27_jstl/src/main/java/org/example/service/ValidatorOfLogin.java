package org.example.service;

public class ValidatorOfLogin implements UserValidator {
    @Override
    public Boolean isValid(String login, String password) {
        if(login == null || login.isBlank() || password == null || password.isBlank()) {
            return false;
        } else {
            return true;
        }
    }

}
