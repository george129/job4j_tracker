package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String idFind = in.askStr("Enter id to find: ");
        Item itmFind = tr.findById(idFind);
        if (itmFind != null) {
            out.println("found: [" + itmFind.getId() + "]:" + itmFind.getName());
        } else {
            out.println("Nothing found with id " + idFind);
        }
        return true;
    }
}
