package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output o) {
        out = o;
    }

    public void init(Input in, Tracker tr, UserAction[] action) {
        boolean run = true;
        while (run) {
            this.showMenu(action);
            int select = in.askInt("");
            if (select < 0 || select > action.length - 1) {
                out.println("Wrong menu number. From 0 to " + (action.length - 1) + " allowed");
                continue;
            }
            run = action[select].execute(in, tr);
        }
    }


    private void showMenu(UserAction[] actions) {
        out.println("Menu");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + "." + actions[i].name());
        }
        out.print("Enter choice number: ");
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tr = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ListAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tr, actions);
    }
}
