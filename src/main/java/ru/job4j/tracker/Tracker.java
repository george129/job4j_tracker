package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    private List<Item> items = new ArrayList<Item>();

    public String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }

    public Item add(Item item) {
        if (item == null) {
            return null;
        }
        item.setId(generateId());
        items.add(item);
        return items.get(items.size()-1);
    }

    public boolean replace(String id, Item item) {
        int n = indexOf(id);
        if (n >= 0) {
            item.setId(id);
            items.set(n, item);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        int n = indexOf(id);
        if (n >= 0) {
            items.remove(n);
            return true;
        }
        return false;
    }

    private int indexOf(String id) {
        int ind = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                ind = i;
                break;
            }
        }
        return ind;
    }

    public List<Item> findAll() {
        List ret =  new ArrayList<Item>();//items.toArray();
        ret.addAll(items);
        return ret;
    }

    public List<Item> findByName(String key) {
        List found = new ArrayList<Item>();
        int indx = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
                found.add(items.get(i));
                indx++;
            }
        }
        return found;
    }

    public Item findById(String id) {
        int indx = indexOf(id);
        return indx < 0 ? null : items.get(indx);
    }
}
