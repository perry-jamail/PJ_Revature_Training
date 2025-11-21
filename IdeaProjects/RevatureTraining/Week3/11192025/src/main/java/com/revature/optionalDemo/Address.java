// Create a class named address having the following fields: street, city, and zip code. Create constructors, getters/setters
// and toString methods. Create another class as Person having name, phone, and address. Create main class wherein define or create
// two person objects with one with address and one without address and check the nullability of address.

package com.revature.optionalDemo;

public class Address {
    private String street;
    private String city;
    private int zipCode;

    public Address(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public void setZipCode(int newZip) {
        this.zipCode = newZip;
    }
}
