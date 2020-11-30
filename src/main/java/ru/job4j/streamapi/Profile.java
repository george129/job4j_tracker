package ru.job4j.streamapi;

import ru.job4j.search.Person;

public class Profile {
    private Address address;

    private String name;

    public Profile(Address addr, String prsn) {
        address = addr;
        name = prsn;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

}