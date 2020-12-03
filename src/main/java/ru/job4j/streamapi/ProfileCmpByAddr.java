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
        } else {
            int s = left.getStreet().compareTo(right.getStreet());
            if (s != 0) {
                return s;
            } else {
                int h = left.getHome() - right.getHome();
                if (h != 0) {
                    return h;
                } else {
                    int a = left.getApartment() - right.getApartment();
                    if (a != 0) {
                        return a;
                    }
                }
            }
            return 0;
        }
    }
    private int cmp(Function<Integer, Integer> func, Integer i) {
        return func.apply(i);
    }
}
