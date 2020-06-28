package ru.job4j.tracker;

public class ListAction implements UserAction {
    private final Output out;

    public ListAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        Item[] itarrList = tr.findAll();
        if (itarrList.length != 0) {
            for (int i = 0; i < itarrList.length; i++) {
                out.println("[" + itarrList[i].getId() + "]:" + itarrList[i].getName());
            }
        } else {
            out.println("Empty");
        }
        return true;
    }
}
