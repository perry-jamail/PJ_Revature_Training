// Modify the below program to sort in the reverse order

package com.revature.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {
    static void main(String[] args) {
        List<String> names = new ArrayList<String>();

        names.add("Perry");
        names.add("Kenzie");
        names.add("Amara");
        names.add("Harper");

        System.out.println(names);

        Collections.sort(names, Collections.reverseOrder());
        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);
    }
}
