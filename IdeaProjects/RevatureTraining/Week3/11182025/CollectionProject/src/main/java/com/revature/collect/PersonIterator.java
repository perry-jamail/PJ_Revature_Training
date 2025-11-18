// Create a list to add an iterative over 5 objects of person having id, name, and age

package com.revature.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PersonIterator {
    static void main(String[] args) {
        Person p1 = new Person(1, "Perry", 25);
        Person p2 = new Person(2, "Kenzie", 24);
        Person p3 = new Person(3, "Amara", 0);
        Person p4 = new Person(4, "Harper", 5);
        Person p5 = new Person(5, "Emma", 22);

        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
