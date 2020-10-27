package ru.job4j.oop;

public class Tiger extends Predator {

    public Tiger() {
        super();
        System.out.println("Tiger");
    }

    public Tiger(String nm) {
        super(nm);
        System.out.println("Tiger with name " + super.name);
    }


    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal("Red beast\n");

        Predator p1 = new Predator();
        Predator p2 = new Predator("Wolfenstein\n");

        Tiger t1 = new Tiger();
        Tiger t2 = new Tiger("Sherhan");
    }

}
