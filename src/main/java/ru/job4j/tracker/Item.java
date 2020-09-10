package ru.job4j.tracker;

public class Item implements Comparable<Item>{
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
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int compareTo(Item itm) {
        return name.compareTo(itm.getName());
    }
}
