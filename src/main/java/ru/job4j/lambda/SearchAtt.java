package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Predicate<Attachment> func = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment att) {
                return att.getSize() > size;
            }
        };
        return filter(func, list);
    }

    public static List<Attachment> filterName(List<Attachment> list, String word) {
        Predicate<Attachment> func = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment att) {
                return att.getName().contains(word);
            }
        };
        return filter(func, list);
    }

    private static List<Attachment> filter(Predicate<Attachment> pr, List<Attachment> input) {
        List<Attachment> ret = new ArrayList<>();
        for (Attachment att : input) {
            if (pr.test(att)) {
                ret.add(att);
            }
        }
        return ret;
    }
}