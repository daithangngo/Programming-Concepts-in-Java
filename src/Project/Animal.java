package Project;

public class Animal {
     private String name;
     private int age;
     private int id;

    public Animal(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
}

class Leopard extends Animal{
    private double tailLength;

    public Leopard(String name, int age, int id, double tailLength) {
        super(name, age, id);
        this.tailLength = tailLength;
    }

    public Leopard(String name, int age, int id) {
        super(name, age, id);
    }
}

class Cat extends Leopard{

    public Cat(String name, int age, int id, double tailLength) {
        super(name, age, id, tailLength);
    }

    public Cat(String name, int age, int id) {
        super(name, age, id);
    }
}
