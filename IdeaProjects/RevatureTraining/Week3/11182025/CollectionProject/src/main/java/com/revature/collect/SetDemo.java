package com.revature.collect;

// HashSet is unordered
// TreeSet is alphabetically ordered, AKA "natural ordering"

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    static void main(String[] args) {
        Set<String> names = new TreeSet<>();

        names.add("Perry");
        names.add("Kenzie");
        names.add("Amara");
        names.add("Harper");
        names.add("Harper");

        for (String name : names) {
            System.out.println(name);
        }

        names.remove("Harper");
        System.out.println(names);

        System.out.println(names.contains("Amara"));
    }
}
