package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparatorAsc implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.compareTo(item2);
    }
}
