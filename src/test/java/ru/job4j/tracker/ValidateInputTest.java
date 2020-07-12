package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void wrongInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"nan", "1"}
        );
        ValidateInput vin = new ValidateInput(out, in);
        int selected = vin.askInt("Enter menu");
        assertThat(selected, is(1));
    }

    @Test
    public void correctInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-100", "500"});
        ValidateInput vin = new ValidateInput(out, in);
        assertEquals(-100, vin.askInt(""));
        assertEquals(500, vin.askInt(""));
    }

    @Test
    public void outputTest() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"nan", "1"}
        );
        ValidateInput vin = new ValidateInput(out, in);
        int selected = vin.askInt("Enter menu");
        assertThat("Enter valid data again" + System.lineSeparator(), is(out.toString()));
    }
}