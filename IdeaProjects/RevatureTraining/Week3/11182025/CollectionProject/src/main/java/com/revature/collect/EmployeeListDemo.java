// Create 5 instances of employee and add them to a list. Display list. Display list sorted
// by id. Display list sorted by name. Display list sorted by salary.

package com.revature.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EmployeeListDemo {
    static void main(String[] args) {
        Employee e1 = new Employee(1, "Perry", 50000.00);
        Employee e2 = new Employee(2, "Kenzie", 70000.00);
        Employee e3 = new Employee(3, "Harper", 20000.00);
        Employee e4 = new Employee(4, "Amara", 100000.00);
        Employee e5 = new Employee(5, "Emma", 40000.00);
        ArrayList<Employee> employees = new ArrayList<Employee>(Arrays.asList(e5, e2, e1, e4, e3));

        System.out.println(employees);

        Collections.sort(employees, new SortByID());
        System.out.println(employees);

        Collections.sort(employees, new SortByName());
        System.out.println(employees);

        Collections.sort(employees, new SortBySalary());
        System.out.println(employees);
    }
}
