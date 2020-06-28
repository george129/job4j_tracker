package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        out.println("Exiting...");
        return false;
    }
}
