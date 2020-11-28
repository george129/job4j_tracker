package ru.job4j.search;

import org.junit.Assert;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @org.junit.Test
    public void add() {
        PhoneDictionary pd = new PhoneDictionary();
        pd.add(new Person("Ivan", "Sidorov", "89001234567", "Earth"));
        pd.add(new Person("Serge", "Neznaikin", "89221234567", "Eurasia"));
        ArrayList<Person> res = pd.find("ido");
        Assert.assertThat(res.get(0).getName(), is("Ivan"));
        ArrayList<Person> res2 = pd.find("znai");
        Assert.assertThat(res2.get(0).getName(), is("Serge"));
    }

    @org.junit.Test
    public void find() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        assertThat(phones.find("yansk").get(0).getSurname(), is("Arsentev"));
        assertThat(phones.find("348").get(0).getSurname(), is("Arsentev"));
        assertThat(phones.find("Pet").get(0).getSurname(), is("Arsentev"));
        assertThat(phones.find("sent").get(0).getSurname(), is("Arsentev"));
        assertEquals(phones.find("Jean").size(), 0);
    }
}