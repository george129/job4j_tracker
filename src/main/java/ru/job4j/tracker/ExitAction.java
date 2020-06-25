package ru.job4j.tracker;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        System.out.println("Exiting...");
        return false;
    }
}
