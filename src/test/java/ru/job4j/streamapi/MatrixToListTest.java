package ru.job4j.streamapi;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    private Integer[][] a;

    @Before
    public void prepare() {
        a = new Integer[][]{
                {3, 5, 1},
                {4, 6, 2},
                {7, 9, 8}
        };
    }

    @Test
    public void toList() {
        List<Integer> expect = Arrays.asList(3, 5, 1, 4, 6, 2, 7, 9, 8);
        assertThat(MatrixToList.toList(a), is(expect));
    }

}