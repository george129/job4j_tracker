package ru.job4j.streamapi;

import java.util.List;

public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String nm, List<Subject> subjs) {
        name = nm;
        subjects = subjs;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
