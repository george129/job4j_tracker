package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person p) {
        persons.add(p);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name =  (p) -> p.getName().contains(key);
        Predicate<Person> surname = (p) -> p.getSurname().contains(key);
        Predicate<Person> address = (p) -> p.getAddress().contains(key);
        Predicate<Person> phone = (p) -> p.getPhone().contains(key);
        var combined = phone.or(address.or(name.or(surname)));
        var result = new ArrayList<Person>();
        for (var p: persons) {
            if (combined.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    private boolean check(Predicate<Person> predct) {
        return false;
    }
}
