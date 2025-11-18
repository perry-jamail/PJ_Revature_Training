package com.revature.collect;

import java.util.Comparator;

public class SortByID implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getId() - e2.getId();
    }
}
