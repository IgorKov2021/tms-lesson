package org.example;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Application> applications = new ArrayList<>();

    static {
        applications.add(new Application("Number 1", "Buy!"));
        applications.add(new Application ("Number 2", "Wash!"));
    }
    public static List<Application> getApp() {
        return applications;
    }
}
