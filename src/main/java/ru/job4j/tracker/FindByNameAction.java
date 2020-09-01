package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String findName = in.askStr("Enter name to find: ");
        List<Item> itarrFind = new ArrayList<Item>();
        itarrFind.addAll(tr.findByName(findName));
        if (itarrFind.size() != 0) {
            for (int i = 0; i < itarrFind.size(); i++) {
                out.println("[" + (itarrFind.get(i).getId() ) + "]:" + itarrFind.get(i).getName());
            }
        } else {
            out.println("Nothing found for \"" + findName + "\"");
        }
        return true;
    }
}
