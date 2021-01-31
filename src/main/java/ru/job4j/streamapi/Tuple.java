package ru.job4j.streamapi;

import java.util.Objects;

public class Tuple {
    private String name;
    private double score;

    public Tuple(String nm, double dscore) {
        name = nm;
        score = dscore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuple t = (Tuple) obj;

        return Double.compare(t.score, score) == 0
                && Objects.equals(name, t.name);
    }

    @Override
    public String toString() {
        return "{" + name + " " + score + "}";
    }

}
