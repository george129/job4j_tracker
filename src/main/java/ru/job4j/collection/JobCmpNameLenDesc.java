package ru.job4j.collection;

import java.util.Comparator;

public class JobCmpNameLenDesc implements Comparator<Job> {
    @Override
    public int compare(Job left, Job right) {
        return Integer.compare(right.getName().length(), left.getName().length());
    }
}
