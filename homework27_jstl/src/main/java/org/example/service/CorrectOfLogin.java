package org.example.service;

import org.example.info.DatabaseOfUsers;
import org.example.info.User;

import java.util.List;

public class CorrectOfLogin implements UserValidator{
    @Override
    public Boolean isValid(String login, String password) {
        List<User> userList = DatabaseOfUsers.getUserList();
        return userList.stream()
                . anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
    }
}
