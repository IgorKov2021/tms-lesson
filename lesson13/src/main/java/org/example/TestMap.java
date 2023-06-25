package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    public Map <TypeOfEmp, Integer> getQuantityOfEmployers(List<Employee> list) {
        if (list == null) {
            return null;
        }
        Map<TypeOfEmp, Integer> mapEmp = new HashMap<>();

        for (Employee emp : list) {
            TypeOfEmp type = emp.getType();
            if (mapEmp.containsKey(type)) {
                mapEmp.put(type, mapEmp.get(type) + 1);

            } else {
                mapEmp.put(type, 1);
            }


        }
        return mapEmp;
    }
}
