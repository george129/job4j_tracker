package search;

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
    }
}