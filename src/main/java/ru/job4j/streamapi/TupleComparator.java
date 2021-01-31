package ru.job4j.streamapi;

import java.util.Comparator;

public class TupleComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple left, Tuple right) {
        return Double.compare(left.getScore(), right.getScore());
    }
}
