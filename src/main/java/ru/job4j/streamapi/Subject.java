package ru.job4j.streamapi;

public class Subject {
    private String name;
    private int score;

    public Subject(String nm, int scr) {
        name = nm;
        score = scr;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
