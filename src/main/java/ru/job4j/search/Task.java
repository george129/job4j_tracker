package ru.job4j.search;

public class Task {
    private String desc;
    private int priority;

    /**
     *
     * @param description - String with text describing the task
     * @param priorityNumber - The higher the number the task would be executed more lately
     */
    public Task(String description, int priorityNumber) {
        desc = description;
        priority = priorityNumber;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
