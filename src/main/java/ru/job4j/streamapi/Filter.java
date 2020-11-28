package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            nums.add((int) (Math.random() * 100 - 50));
        }
        for (Integer num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
        List<Integer> positive = nums.stream()
                .filter((ints) -> ints >= 0)
                .collect(Collectors.toList());
        for (Integer num : positive) {
            System.out.print(num + "\t");
        }
    }
}
