package ru.job4j.tracker;

public class StartUI {


    public void init(Input in, Tracker tr, UserAction[] action) {
        boolean run = true;
        while (run) {
            this.showMenu(action);
            int select = in.askInt("");
            run = action[select].execute(in, tr);
        }
    }


    private void showMenu(UserAction[] actions) {
        System.out.println("Menu");
        for (int i = 0; i < actions.length; i++){
            System.out.println(i + "." + actions[i].name());
        }
        System.out.print("Enter choice number: ");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tr = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ListAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tr, actions);
    }
}
