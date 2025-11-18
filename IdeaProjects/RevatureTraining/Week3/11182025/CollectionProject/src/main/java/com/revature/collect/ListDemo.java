package com.revature.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        //myList.add(1);
        myList.add("Perry");
        myList.add("Amara");
        myList.add("Harper");
        myList.add(1, "Kenzie");
        //myList.add(10.3);

        System.out.println(myList.get(1));

        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        for (String str : myList) {
            System.out.println(str);
        }

        myList.remove(1);
        System.out.println(myList);

        // *Assignment* Iterate through a list from the end to the beginning of the list
        for (int i = myList.size() - 1; i >= 0; i--) {
            System.out.println(myList.get(i));
        }
    }
}
