package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output o, Input inp) {
        out = o;
        in = inp;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (IllegalStateException ex) {
                out.println("Select key from menu");
            } catch (NumberFormatException fex) {
                out.println("Enter valid data again");
            }
        } while (invalid);
        return value;
    }

}
