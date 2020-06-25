package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input in, Tracker tr) {
        String idDelete = in.askStr("Enter Id to delete: ");
        if (tr.delete(idDelete)) {
            System.out.println("Item " + idDelete + " deleted.");
        } else {
            System.out.println("Error while tried to delete id=" + idDelete);
        }
        return true;
    }
}
