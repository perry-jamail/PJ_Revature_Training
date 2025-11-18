// *Assignment* Try the collection interface methods

package com.revature.collect;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListImp {
    static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();

        myList.add(4);
        System.out.println(myList);

        ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
        myList.addAll(intList);
        System.out.println(myList);

        myList.remove(4);
        System.out.println(myList);

        System.out.println(myList.contains(4));

        myList.clear();
        System.out.println(myList);

        System.out.println(myList.contains(4));

        System.out.println(myList.isEmpty());
    }
}
