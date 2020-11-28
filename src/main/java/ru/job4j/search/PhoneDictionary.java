package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person p) {
        persons.add(p);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getName().contains(key);
            }
        };
        Predicate<Person> surname = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getSurname().contains(key);
            }
        };
        Predicate<Person> address = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAddress().contains(key);
            }
        };
        Predicate<Person> phone = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getPhone().contains(key);
            }
        };
        Predicate<Person> comb = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return phone.or(address.or(name.or(surname))).test(p);
            }
        };
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person p: persons) {
            if (comb.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    private boolean check(Predicate<Person> predct) {
        return false;
    }
}
