package org.example.service;

import org.example.info.Activities;
import org.example.info.DatabaseOfUsers;
import org.example.info.User;

import java.util.List;
import java.util.Optional;

public class ServiceOfUsers {

    public String getLogin(String login, String password) {
        ValidatorOfLogin validatorOfLogin = new ValidatorOfLogin();
        Boolean valid = validatorOfLogin.isValid(login, password);

        if (valid) {
            CorrectOfLogin correctOfLogin = new CorrectOfLogin();
            Boolean correct = correctOfLogin.isValid(login, password);
            if (correct) {
                return login;
            } else {
                return "wrong";
            }
        } else {
            return "blank";
        }

    }
    public User getUser(String login) {
        List<User> userList = DatabaseOfUsers.getUserList();
        Optional<User> first = userList.stream()
                .filter(user -> user.getLogin().equals(login)).findFirst();
        User user = first.get();

        return user;
    }

}
