package org.example.info;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfUsers {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("Igor","Petrov", "123", "petrov@mail.ru","PI87"));
        userList.add(new User("Vadim","Ivanov", "1", "ivanov@mail.ru","IV86"));
        User user = new User("Petr","Cardanov", "1234", "cardanov@mail.ru","PC92");
        Activities activity1 = new Activities("Play");
        Activities activity2 = new Activities("Washing");
        user.setUserActivities(List.of(activity1,activity2));
        userList.add(user);
    }

    public static List<User> getUserList() {
        return userList;
    }

}
