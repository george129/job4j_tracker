package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compare() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("One"));
        itemList.add(new Item("Two"));
        itemList.add(new Item("Three"));
        itemList.add(new Item("Four"));
        Collections.sort(itemList, new ItemComparatorAsc());
        assertEquals(Arrays.asList(new Item("Four"), new Item("One"), new Item("Three"), new Item("Two")), itemList);
//        assertEquals("Four", itemList.get(0).getName());
//        assertEquals("One", itemList.get(1).getName());
//        assertEquals("Three", itemList.get(2).getName());
//        assertEquals("Two", itemList.get(3).getName());
        Collections.sort(itemList, new ItemComparatorDesc());
        assertEquals(Arrays.asList(new Item("Two"), new Item("Three"), new Item("One"), new Item("Four")), itemList);
//        assertEquals("Two", itemList.get(0).getName());
//        assertEquals("Three", itemList.get(1).getName());
//        assertEquals("One", itemList.get(2).getName());
//        assertEquals("Four", itemList.get(3).getName());

    }
}