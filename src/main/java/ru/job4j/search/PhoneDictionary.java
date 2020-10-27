package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person p) {
        persons.add(p);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person p: persons) {
            if (p.getName().contains(key)
                    || p.getSurname().contains(key)
                    || p.getPhone().contains(key)
                    || p.getAddress().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}
