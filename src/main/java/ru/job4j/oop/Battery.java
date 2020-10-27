package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int chrg) {
        this.load = chrg;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }
    public void show() {
        System.out.println(this.load);
    }

    public static void main(String[] args) {
        Battery b1 = new Battery(3);
        Battery b2 = new Battery(7);
        b1.show();
        b2.show();

        b2.exchange(b1);

        b1.show();
        b2.show();
    }


}
