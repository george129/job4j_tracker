package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();


    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */

    public void put(Task task) {
        int index = 0;
        for(Task element: tasks) {
            if(task.getPriority() < element.getPriority()) {
                tasks.add(index, task);
                return;
            }
            index++;
        }
        tasks.addLast(task); ;
    }

    public Task take() {
        return tasks.poll();
    }
}
