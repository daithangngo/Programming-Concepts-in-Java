package FunctionalProgramming;

import java.util.List;
import java.util.function.Supplier;

//represents a supplier of results
//returns any kind of value that we want
//for examle return list, array, object,...
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://local:5432/users";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = ()
            -> List.of(
            "jdbc://local:5432/users",
            "jdbc://local:5432/customer");
}