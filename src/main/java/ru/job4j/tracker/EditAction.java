package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output o) {
        out = o;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String idEdit = in.askStr("Enter ID to edit: ");
        String newName = in.askStr("New item name: ");
        if (tr.replace(idEdit, new Item(newName))) {
            out.println("Replace completed.");
        } else {
            out.println("Error while tried to edit id=" + idEdit);
        }
        return true;
    }
}
