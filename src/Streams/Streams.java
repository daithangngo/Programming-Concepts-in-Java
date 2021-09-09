package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class Streams {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("Hello");
    list.add("Hello");
    list.add("World");
    list.add("World");
    list.add("Teemo");

    Map<String, Long> counted = list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(counted);
  }

  //get the sum of the 3 biggest numbers
  static int sumOfB(int[] arr) {
    //return Arrays.stream(arr).map(i->-i).sorted().map(i->-i).limit(3).sum();
    //sorted the smallest numbers come first
    return Arrays.stream(arr).sorted().skip(arr.length - 3).sum();
  }

  int[] primes(int max) {
    return IntStream.range(2, max + 1).filter(num ->
            IntStream.range(2, num).allMatch(div -> num % div != 0)).toArray();
  }

//countMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
}
