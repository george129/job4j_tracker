package ru.job4j.tracker;

import java.util.Objects;

public class ConsoleOutput implements  Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }
}
