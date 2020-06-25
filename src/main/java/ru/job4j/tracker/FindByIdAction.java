package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String idFind = in.askStr("Enter id to find: ");
        Item itmFind = tr.findById(idFind);
        if (itmFind != null) {
            System.out.println("found: [" + itmFind.getId() + "]:" + itmFind.getName());
        } else {
            System.out.println("Nothing found with id " + idFind);
        }
        return true;
    }
}
