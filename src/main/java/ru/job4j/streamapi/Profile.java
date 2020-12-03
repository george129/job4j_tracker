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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Profile profile = (Profile) o;

        if (!address.equals(profile.address)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public String toString() {
        return "Profile{" + "address=" + address + ", name='" + name + '\'' + '}';
    }
}