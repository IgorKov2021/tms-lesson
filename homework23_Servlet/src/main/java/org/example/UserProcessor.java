package org.example;


import java.util.List;
;

public class UserProcessor {
    List<User> listOfUsers = List.of(new User("Egor", "Petrov",
            "EgPet", "Petrov@mail.ru", 21 , "a1" ), new User("Vadim", "Ivanov",
            "IvanV", "Ivanov@mail.ru", 25, "abc24"));
    public boolean checkEnter(String login, String password) {
        if(login == null || password == null || login.isBlank() || password.isBlank()) {
            return false;
        }

        for (User user: listOfUsers) {
             if (user.getLogin().equals(login)) {
                 return user.getPass().equals(password);

        }

        }
        return false;
        }
    }

