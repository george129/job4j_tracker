package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answer = {"0", "Just for test", "0", "List", "0", "All", "0", "Items", "1"};
        Input in = new StubInput(answer);
        Tracker tr = new Tracker();
        UserAction[] acts = {
                new CreateAction(),
                new ExitAction()
        } ;
        new StartUI().init(in, tr, acts);
        Item[] created = tr.findAll();
        Assert.assertEquals(created[0].getName(), answer[1]);
        Assert.assertEquals(created[1].getName(), answer[3]);
        Assert.assertEquals(created[2].getName(), answer[5]);
        Assert.assertEquals(created[3].getName(), answer[7]);
    }

    @Test
    public void editItem() {
        Tracker tr = new Tracker();
        Item it = new Item("test");
        tr.add(it);
        String[] answers = {"0", it.getId(), "edited test", "1"};
        Input in = new StubInput(answers);
        UserAction[] acts = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, tr, acts);
        Assert.assertEquals(answers[2], tr.findById(answers[1]).getName());
    }

    @Test
    public void deleteItem() {
        Tracker tr = new Tracker();
        Item[] items = new Item[3];
        tr.add(new Item("test1"));
        String deletedId = tr.add(new Item("test2")).getId();
        tr.add(new Item("test3"));
        String[] answers = {"0", deletedId, "1"};
        Input in = new StubInput(answers);
        UserAction[] acts = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, tr, acts);
        Item[] itemsAfterEdit;
        tr.delete(deletedId);
        itemsAfterEdit = tr.findAll();
        Assert.assertEquals(2, itemsAfterEdit.length);
        Assert.assertEquals("test1", itemsAfterEdit[0].getName());
        Assert.assertEquals("test3", itemsAfterEdit[1].getName());
        Assert.assertEquals(null, tr.findById(deletedId));
    }

    @Test
    public void findItemById() {
    }

    @Test
    public void findItemByName() {
    }
}