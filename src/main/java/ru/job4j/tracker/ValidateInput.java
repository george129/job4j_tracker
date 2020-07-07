package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (IllegalStateException ex) {
                System.out.println("Select key from menu");
            } catch (NumberFormatException fex) {
                System.out.println("Enter valid data again");
            }
        } while (invalid);
        return value;
    }

}
