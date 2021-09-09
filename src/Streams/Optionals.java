package Streams;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        //Optional.of()- use when we know for sure that the value is not null
        //Optional.ofNullable- when we don't know whether there might be a null or not

        Optional<String> hello = Optional.ofNullable("hello");

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        hello.ifPresent(world -> System.out.println( hello + "world"));

    }
}