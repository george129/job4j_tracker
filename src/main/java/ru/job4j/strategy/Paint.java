package ru.job4j.strategy;

public class Paint {
    char[] chars;

    public void draw(Shape sh) {
        System.out.print(sh.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
