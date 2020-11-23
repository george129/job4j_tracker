package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface Range {
    public static List<Double> range(int start, int end, Function<Double, Double> func) {
        List<Double> ret = new ArrayList<>();
        for (int i = start; i < end; i++) {
            ret.add(func.apply((double) i));
        }
        return ret;
    }
}
