package com.revature.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Double> persons = new HashMap<String, Double>();

        persons.put("Amara", 100000.00);
        persons.put("Kenzie", 250000.00);
        persons.put("Perry", 200000.00);
        persons.put("Amara", 150000.00);

        System.out.println(persons);
        System.out.println(persons.get("Amara"));

        Set<String> names = persons.keySet();
        for (String name : names) {
            System.out.println(name + ", " + persons.get(name));
        }
    }
}
