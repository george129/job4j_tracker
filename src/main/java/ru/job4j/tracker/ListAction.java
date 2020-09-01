package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
        List<Item> itarrList = new ArrayList<Item>();
        itarrList.addAll(tr.findAll());
        if (itarrList.size() != 0) {
            for (int i = 0; i < itarrList.size(); i++) {
                out.println("[" + itarrList.get(i).getId() + "]:" + itarrList.get(i).getName());
            }
        } else {
            out.println("Empty");
        }
        return true;
    }
}
