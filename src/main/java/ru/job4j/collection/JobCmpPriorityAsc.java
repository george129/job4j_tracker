package ru.job4j.collection;

import java.util.Comparator;

public class JobCmpPriorityAsc implements Comparator<Job> {
    @Override
    public int compare(Job job0, Job job1) {
        return Integer.compare(job0.getPriority(), job1.getPriority());
    }
}
