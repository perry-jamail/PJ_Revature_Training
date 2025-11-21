// Create a class named address having the following fields: street, city, and zip code. Create constructors, getters/setters
// and toString methods. Create another class as Person having name, phone, and address. Create main class wherein define or create
// two person objects with one with address and one without address and check the nullability of address.

package com.revature.optionalDemo;

import java.util.Optional;

public class Main {
    static void main(String[] args) {
        Address a1 = new Address("0904 Sample St.", "Sample", 78613);

        Person p1 = new Person("Amara", 1234567891, a1);
        Person p2 = new Person("Kenzie", 1111111111, new Address("0822 Sample St.", "Sample", 78613));

        Optional<Address> checkNull = Optional.ofNullable(p2.getAddress());
        if (checkNull.isPresent()) {
            System.out.println(p2.getAddress());
        } else {
            System.out.println("Address is null");
        }
    }
}
