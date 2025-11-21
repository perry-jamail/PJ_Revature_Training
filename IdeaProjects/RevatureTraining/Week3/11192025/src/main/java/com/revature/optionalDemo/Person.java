// Create a class named address having the following fields: street, city, and zip code. Create constructors, getters/setters
// and toString methods. Create another class as Person having name, phone, and address. Create main class wherein define or create
// two person objects with one with address and one without address and check the nullability of address.

package com.revature.optionalDemo;

public class Person {
    private String name;
    private double phone;
    private Address address;

    public Person(String name, int phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Person(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
