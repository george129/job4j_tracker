package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String findName = in.askStr("Enter name to find: ");
        Item[] itarrFind = tr.findByName(findName);
        if (itarrFind.length != 0) {
            for (int i = 0; i < itarrFind.length; i++) {
                System.out.println("[" + itarrFind[i].getId() + "]:" + itarrFind[i].getName());
            }
        } else {
            System.out.println("Nothing found for \"" + findName + "\"");
        }
        return true;
    }
}
