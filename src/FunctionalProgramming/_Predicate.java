package FunctionalProgramming;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

//represents a predicate (boolean-valued function) of one argument
//we write the function/implement its interface , then we use it by
//cool thing about Predicate: we can have a lot of predicates and then simply chaining them together
public class _Predicate {
    public static void main(String[] args) {

        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09800780000"));

        System.out.println("with predicate");
        System.out.println(isPhoenNumberValidPredicate.test("07000000000"));

        //and both predicates has to be true , or at least one of them must be true
        System.out.println("Is phone number valid and contains the number 3 = "
                + isPhoenNumberValidPredicate.and(containsNumber3).test("07000000000"));

        System.out.println("Is phone number valid or contains the number 3 = "
                + isPhoenNumberValidPredicate.or(containsNumber3).test("07000000000"));


        System.out.println("Is phone number valid and contains the number 3 = "
                + isPhoenNumberValidPredicate.and(containsNumber3).test("07003050200"));

        System.out.println("Those two numbers are both valid = "
                + areBothNumbersAreValid.test("07003050200","07000000000" ));

        System.out.println("Those two numbers are both valid = "
                + areBothNumbersAreValid.test("08003050200","07000000000" ));
    }

    //we can have 2 predicates
    static BiPredicate<String, String> areBothNumbersAreValid = (arg1, arg2)
            -> arg1.startsWith("07") && arg2.length() == 11;

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoenNumberValidPredicate =
            phoneNumber-> phoneNumber.startsWith("07") && phoneNumber.length()==11;

    static Predicate<String> containsNumber3 = phoneNumber->
            phoneNumber.contains("3");
}

