package org.example;

import java.util.List;
import java.util.Map;

public class TestMap {
    public void getQuantityOfEmployers(Map map, List<Employee> list) {
        int i = 0;
        int k = 0;
        for (Employee emp : list) {
            if (emp instanceof Director) {
                i++;
                map.put(emp, i);

            } else {
                k++;
                map.put(emp, k);
            }

        }
        System.out.println("Кол-во инженеров = " + k);
        System.out.println("Кол-во дтректоров = " + i);
    }

}
