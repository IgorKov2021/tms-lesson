package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestMap {
    Integer i = 1;

    public void getQuantityOfEmployers(Map map, List<Employee> list) {

        if (list != null) {
            map.put(list.get(0).getType(), i);
        }
        for (Employee emp : list) {
            TypeOfEmp type = emp.getType();

            if (map.containsKey(type)) {
                i = (Integer) map.get(type);
                map.put(type, i + 1);
            } else {
                i = 1;
                map.put(type, i);
            }


        }

    }

}
