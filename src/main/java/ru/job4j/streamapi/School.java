package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> stud, Predicate<Student> pdct) {
        return stud.stream()
                .filter(pdct)
                .collect(Collectors.toList());
    }

    Map<String, Student> toMap(List<Student> ls) {
        return ls.stream()
                .collect(Collectors.toMap(st -> st.getSurname(), st -> st));
    }
}
