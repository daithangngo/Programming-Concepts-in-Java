package FunctionalProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

//BiConsumer, Bi... they all do the same thing as normal Function: taking 2 arguments and producing 1 result

public class _BiFunction {
    public static void main(String[] args) {

        //Java normal function
        System.out.println(incrementByOneAndMultiply(4, 100));

        //BiFunction takes 2 arguments and produces 1 result
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));
    }

    static int incrementByOne(int number){
        return number +1;
    }

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy){
        return (number +1) * 100;
    }

    //2 input Integer and produces 1 output Integer
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementBy1, numberToMultiplyBy)
                    ->(numberToIncrementBy1 + 1) * numberToMultiplyBy;

    /*
    public static Map<Integer, List<Person>> groupByAge(List<Person> input) {
		return input.stream().collect(Collectors.groupingBy(Person::getAge));
	}
     */

    public static Set<Integer> mostFrequentElements(int[] arr) {

        Map<Integer, Integer> counts = new HashMap<>(); // oder TreeMap
        for (int elem : arr) {
            Integer oldCount = counts.get(elem);
            counts.put(elem, oldCount == null ? 1 : oldCount+1);
        }
        int max = 0;
        for (int count : counts.values())
            if (count > max)
                max = count;
        Set<Integer> mostFrequent = new HashSet<>(); // oder TreeSet

        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
            if (entry.getValue() == max)
                mostFrequent.add(entry.getKey());
        return mostFrequent;
    }

}
