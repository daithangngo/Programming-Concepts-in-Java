package MathAlgo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class PrimeFactors {

  public static void main(String args[]) {
    long number;
    Scanner sc = new Scanner(System.in);
    System.out.println("Primzahlzerlegung von: ");
    number = sc.nextLong();
    StringBuilder sb = new StringBuilder();

    for (int i = 2; i < number; i++) {
      ArrayList<Integer> prime = new ArrayList<>();
      while (number % i == 0) {
        prime.add(i);
        number = number / i;
      }
      if (prime.size() == 0) continue;
      String s = (i + "^" + (long) prime.size() + " x ");
      System.out.println(s);
    }

    if (number > 2) {
      System.out.println(number);
    }
  }
}
