package collection;

import org.junit.Test;
import ru.job4j.collection.StringCompare;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenStringsEqual() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultNegative () {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertTrue(rst < 0);
    }

    @Test
    public void whenLeftGreaterThanRightResultPositive () {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertTrue(rst > 0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive(){
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertTrue(rst > 0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative(){
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertTrue(rst < 0);
    }

    @Test
    public void firstCharDifferentCase() {
        StringCompare cmp = new StringCompare();
        assertTrue(cmp.compare("ivanov", "Ivanov") > 0);
    }

    @Test
    public void numbersInSequence() {
        StringCompare cmp = new StringCompare();
        assertTrue(cmp.compare("1abc", "2abc") < 0);
    }
}