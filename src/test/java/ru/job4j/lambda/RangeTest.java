package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Range.range(5, 8, x ->  2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = Range.range(1, 5, x -> 3 * x * x - x - 1);
        List<Double> expected = Arrays.asList(1D, 9D, 23D, 43D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResult() {
        List<Double> result = Range.range(1, 4, x -> Math.pow(2, x) / 2);
        List<Double> expected = Arrays.asList(1D, 2D, 4D);
        assertThat(result, is(expected));
    }
}