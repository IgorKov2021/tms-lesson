package org.example.service;

import org.example.info.User;

public interface UserValidator {
    public Boolean isValid(String login, String password);

}
