package FunctionalProgramming;

import java.util.function.Function;

public class _Function {

  public static void main(String[] args) {

    // Function takes 1 argument and produces 1 result
    int increment = incrementByOne(0);
    System.out.println(increment);

    // apply- is like yeah give me an input and I'll produce an output/result for y
    int increment2 = incrementByOneFunction.apply(2);

    System.out.println(increment2);

    int multiple = multipleBy10Function.apply(increment2);
    System.out.println(multiple);

    // chaining Function together
    Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
        incrementByOneFunction.andThen(multipleBy10Function);

    System.out.println(addBy1AndThenMultiplyBy10.apply(4));
  }

  // takes a number and increment the number by one
  // is a Function-->takes an input and produces an output/result

  static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

  static Function<Integer, Integer> multipleBy10Function = number -> number * 10;

  static int incrementByOne(int num) {
    return num + 1;
  }

  // BiFunction is pretty much the same like Function with the difference that we can take 2 inputs
  // and produce one output
}
