package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * вычисляет общий средний балл
     * @param stream
     * @return
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(subj -> subj.getScore())
                .average()
                .orElse(0D);
    }

    /**
     * вычисляет средний балл ученика по его предметам
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(
                        pupil.getName(),
                        pupil.getSubjects().stream()
                        .mapToInt(subj -> subj.getScore())
                        .average()
                        .orElse(0D)
                        )
                    )
                .collect(Collectors.toList());
    }

    /**
     * вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(), tuple.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
