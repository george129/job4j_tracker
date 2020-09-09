package ru.job4j.tracker;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private String id;
    private String name;

    public Item(String nm) {
        name = nm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Item item) {
/*        char[] outerChars = item.getName().toCharArray();
        char[] innerChars = name.toCharArray();
        int ret = -2;
        for(int i = 0; i < Math.min(outerChars.length, innerChars.length); i++) {
            if (innerChars[i] > outerChars[i]) {
                return 1;
            } else if (innerChars[i] == outerChars[i]) {
                ret = 0;
            } else {
                return -1;
            }
        }
        if (ret == 0 && innerChars.length > outerChars.length) {
            return 1;
        } else if (ret == 0 && innerChars.length < outerChars.length) {
            return -1;
        }*/
        return name.compareTo(item.getName());
        //this.id > item.getId() ? 1 : this.id == item.getId() ? 0 : -1;
    }
}
