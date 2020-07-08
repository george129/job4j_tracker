package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void createItem() {
        Output out = new StubOutput();
        String[] answer = {"0", "Just for test", "0", "List", "0", "All", "0", "Items", "1"};
        Input in = new StubInput(answer);
        Tracker tr = new Tracker();
        UserAction[] acts = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tr, acts);
        Item[] created = tr.findAll();
        Assert.assertEquals(created[0].getName(), answer[1]);
        Assert.assertEquals(created[1].getName(), answer[3]);
        Assert.assertEquals(created[2].getName(), answer[5]);
        Assert.assertEquals(created[3].getName(), answer[7]);
    }

    @Test
    public void editItem() {
        Output out = new StubOutput();
        Tracker tr = new Tracker();
        Item it = new Item("test");
        tr.add(it);
        String[] answers = {"0", it.getId(), "edited test", "1"};
        Input in = new StubInput(answers);
        UserAction[] acts = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tr, acts);
        Assert.assertEquals(answers[2], tr.findById(answers[1]).getName());
    }

    @Test
    public void deleteItem() {
        Output out = new StubOutput();
        Tracker tr = new Tracker();
        Item[] items = new Item[3];
        tr.add(new Item("test1"));
        String deletedId = tr.add(new Item("test2")).getId();
        tr.add(new Item("test3"));
        String[] answers = {"0", deletedId, "1"};
        Input in = new StubInput(answers);
        UserAction[] acts = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tr, acts);
        Item[] itemsAfterEdit;
        tr.delete(deletedId);
        itemsAfterEdit = tr.findAll();
        Assert.assertEquals(2, itemsAfterEdit.length);
        Assert.assertEquals("test1", itemsAfterEdit[0].getName());
        Assert.assertEquals("test3", itemsAfterEdit[1].getName());
        Assert.assertEquals(null, tr.findById(deletedId));
    }

    @Test
    public void findAll() {
        Output out = new StubOutput();
        Tracker tr = new Tracker();
        Item[] items = {
                new Item("test1"),
                new Item("test2"),
                new Item("test3")
        };
        tr.add(items[0]);
        tr.add(items[1]);
        tr.add(items[2]);
        String ls = System.lineSeparator();
        Input in = new StubInput(new String[]{"0", "1"});
        new StartUI(out).init(in, tr, new UserAction[]{new ListAction(out), new ExitAction(out)});
        Assert.assertThat(out.toString(), is("Menu"
                + ls + "0.Show all items"
                + ls + "1.Exit"
                + ls + "Enter choice number: [" + items[0].getId() + "]:" + items[0].getName()
                + ls + "[" + items[1].getId() + "]:" + items[1].getName()
                + ls + "[" + items[2].getId() + "]:" + items[2].getName()
                + ls + "Menu"
                + ls + "0.Show all items"
                + ls + "1.Exit"
                + ls + "Enter choice number: Exiting..."
                + ls));
    }

    @Test
    public void findItemById() {
        Output out = new StubOutput();
        Tracker tr = new Tracker();
        Item t1 = new Item("first test");
        Item t2 = new Item("second test");
        Item t3 = new Item("third test");
        tr.add(t1);
        tr.add(t2);
        tr.add(t3);
        Input in = new StubInput(new String[]{
                "0",
                t2.getId(),
                "1"
        });
        new StartUI(out).init(in, tr, new UserAction[] {
                new FindByIdAction(out), new ExitAction(out)
        });
        String ls = System.lineSeparator();
        Assert.assertThat(out.toString(), is("Menu"
                + ls + "0.Find item by Id"
                + ls + "1.Exit"
                + ls + "Enter choice number: found: [" + t2.getId() + "]:" + t2.getName()
                + ls + "Menu"
                + ls + "0.Find item by Id"
                + ls + "1.Exit"
                + ls + "Enter choice number: Exiting..."
                + ls));
    }

    @Test
    public void findItemByName() {
        Output out = new StubOutput();
        Tracker tr = new Tracker();
        Item t1 = new Item("first test");
        Item t2 = new Item("second test");
        Item t3 = new Item("third test");
        tr.add(t1);
        tr.add(t2);
        tr.add(t3);
        Input in = new StubInput(new String[]{"0", t2.getName(), "1"});
        new StartUI(out).init(in, tr, new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        });
        System.out.println(out.toString());
        String ls = System.lineSeparator();
        Assert.assertThat(out.toString(), is("Menu"
                + ls + "0.Find items by name"
                + ls + "1.Exit"
                + ls + "Enter choice number: [" + t2.getId() + "]:" + t2.getName()
                + ls + "Menu"
                + ls + "0.Find items by name"
                + ls + "1.Exit"
                + ls + "Enter choice number: Exiting..."
                + ls));
    }

    @Test
    public void exit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"0"});
        Tracker tr = new Tracker();
        UserAction[] acts = {new ExitAction(out)};
        new StartUI(out).init(in, tr, acts);
        String ls = System.lineSeparator();
        Assert.assertEquals("Menu"
                + ls + "0.Exit"
                + ls + "Enter choice number: " + "Exiting..."
                + ls, out.toString());
    }

    @Test
    public void invalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"10", "0"});
        Tracker tr = new Tracker();
        UserAction[] acts = {new ExitAction(out)};
        new StartUI(out).init(in, tr, acts);
        String ls = System.lineSeparator();
//        System.out.println(out.toString());
        Assert.assertEquals("Menu"
                + ls + "0.Exit"
                + ls + "Enter choice number: " + "Wrong menu number. From 0 to 0 allowed"
                + ls + "Menu"
                + ls + "0.Exit"
                + ls + "Enter choice number: " + "Exiting..."
                + ls, out.toString());
    }

}