package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Create new item";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String nm = in.askStr("Enter name: ");
        Item it = new Item(nm);
        tr.add(it);
        return true;
    }
}
