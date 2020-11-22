package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Lambdas {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        Comparator<Attachment> compDesc = (left, right) -> right.getName().compareTo(left.getName());
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("Comparing " + right + " and " + left);
            return right.compareTo(left);
        };
        Arrays.sort(atts, compDesc);
    }
}