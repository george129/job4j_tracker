package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output o) {
        out = o;
    }

    public void init(Input in, Tracker tr, List<UserAction> action) {
        boolean run = true;
        while (run) {
            this.showMenu(action);
            int select = in.askInt("");
            if (select < 0 || select > action.size() - 1) {
                out.println("Wrong menu number. From 0 to " + (action.size() - 1) + " allowed");
                continue;
            }
            run = action.get(select).execute(in, tr);
        }
    }


    private void showMenu(List<UserAction> actions) {
        out.println("Menu");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + "." + actions.get(i).name());
        }
        out.print("Enter choice number: ");
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tr = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction(output));
        actions.add(new ListAction(output));
        actions.add(new EditAction(output));
        actions.add(new DeleteAction(output));
        actions.add(new FindByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tr, actions);
    }
}
