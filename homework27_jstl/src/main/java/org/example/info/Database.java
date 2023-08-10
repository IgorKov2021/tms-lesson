package org.example.info;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("Igor","Petrov", "123", "petrov@mail.ru","PI87"));
        userList.add(new User("Vadim","Ivanov", "1", "ivanov@mail.ru","IV86"));
    }
}
