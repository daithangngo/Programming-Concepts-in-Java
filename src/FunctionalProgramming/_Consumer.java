package FunctionalProgramming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

//operation that accepts a single input argument and returns no result
//Consumer is like a void function
//BiConsumer : we take 2 inputs and produce 1 output
//Consumer is like a void method
public class _Consumer {
    public static void main(String[] args) {

        //normal java Function
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);

        //Consumer Functional interface
        greetCostumerConsumer.accept(maria);
        greetCostumerConsumerV2.accept(maria, false);

        setGreetCostumerConsumerV2(maria, true);
        setGreetCostumerConsumerV2(maria, false);

    }

    static BiConsumer<Customer, Boolean> greetCostumerConsumerV2 = (customer, showPhoneNumber)
            -> System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number "
            + (showPhoneNumber ? customer.custerPhoneNumber:"**********"));

    static void setGreetCostumerConsumerV2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.custerPhoneNumber:"**********"));
    }


    //Customer is the data type of the input, customer is the input name
    static Consumer<Customer> greetCostumerConsumer = customer -> System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number "
            + customer.custerPhoneNumber);

    //void is basically a Consumer
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + customer.custerPhoneNumber);
    }

    static class Customer{
        private final String customerName;
        private final String custerPhoneNumber;

        public Customer(String customerName, String custerPhoneNumber) {
            this.customerName = customerName;
            this.custerPhoneNumber = custerPhoneNumber;
        }

        public String getCusterPhoneNumber() {
            return custerPhoneNumber;
        }
    }


}

