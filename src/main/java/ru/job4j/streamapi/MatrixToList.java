package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class MatrixToList {
    public static List<Integer> toList(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(e -> Stream.of(e))
                .collect(Collectors.toList());
    }
}
