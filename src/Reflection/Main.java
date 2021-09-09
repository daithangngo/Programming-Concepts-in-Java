package Reflection;

public class Main {
    public static void main(String[] args) {
        SomeObj so = new SomeObj();
        Class myClass = so.getClass();
        String name = myClass.getName();
        System.out.println(name);
    }
}
