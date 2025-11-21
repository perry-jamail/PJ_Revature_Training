package com.revature.streamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    static void main(String[] args) {
        Employee e1 = new Employee("Amara", 0, 250000);
        Employee e2 = new Employee("Kenzie", 24, 70000);
        Employee e3 = new Employee("Harper", 5, 100000);
        Employee e4 = new Employee("Perry", 25, 50000);
        Employee e5 = new Employee("Emma", 22, 45000);

        List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(e1, e2, e3, e4, e5));
        Stream<Employee> stream = employeeList.stream();
        //stream.forEach(System.out::println);
//        List<String> upperCaseList = stream.map(e -> e.getName().toUpperCase()).toList();
//        upperCaseList.forEach(System.out::println);

        //List<Employee> sortedBySalary = stream.filter(e -> e.getSalary())
    }
}
