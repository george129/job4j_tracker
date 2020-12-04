package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProfileCmpByAddr implements Comparator<Address> {
    @Override
    public int compare(Address left, Address right) {
        int c = left.getCity().compareTo(right.getCity());
        if (c != 0) {
            return c;
        }
        return 0;
    }
}
