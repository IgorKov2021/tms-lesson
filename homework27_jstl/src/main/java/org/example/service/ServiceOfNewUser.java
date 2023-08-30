package org.example.service;

import org.example.info.DatabaseOfUsers;
import org.example.info.User;

import java.util.List;
import java.util.Optional;

public class ServiceOfNewUser{
    public User saveUser(User user)

    {
        ValidatorOfLogin validatorOfLogin = new ValidatorOfLogin();
        Boolean valid = validatorOfLogin.isValid(user.getLogin(), user.getPassword());
        if(valid) {
            Boolean loginIsExist = checkLogin(user.getLogin());
            if(loginIsExist) {
                System.out.println("Существует");
            } else {
                DatabaseOfUsers.getUserList().add(user);
                return user;
            }

        }
        return null;
    }
    public Boolean checkLogin(String login) {
        List<User> userList = DatabaseOfUsers.getUserList();
       return userList.stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }

}