package Multithreading;

import java.util.Scanner;

public class Calculator {
  int a, b, sum;

  public Calculator(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public static void main(String[] args) throws InterruptedException {
    System.out.println("Enter your a:");
    Scanner a = new Scanner(System.in);
    int first = a.nextInt();

    System.out.println("Enter your b:");
    Scanner b = new Scanner(System.in);
    int second = b.nextInt();

    Calculator calc = new Calculator(first, second);
    Thread t1 = new Thread(() -> calc.sum = calc.a + calc.b);

    t1.start();
    t1.join();

    System.out.println("a + b = " + calc.sum);
  }
}
