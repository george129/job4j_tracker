package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row: array) {
            for (int cell: row) {
                list.add(cell);
            }
        }
        System.out.println(f());
        return list;
    }

    public int f() {
        String a = new String("");
        class Aclass {
           void no() throws Error {
               System.out.println("-");
               throw new Error();
           }
        }
        try {
            return 1;
        } finally {
            return 2;
        }
    }

}