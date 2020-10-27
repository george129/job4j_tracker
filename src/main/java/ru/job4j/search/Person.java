package ru.job4j.search;

public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String n, String sn, String ph, String addr) {
        name = n;
        surname = sn;
        phone = ph;
        address = addr;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
