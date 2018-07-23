package functionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by linchpin on 20/7/18.
 */
public class UsingFunctionalInterface {


    Function<Integer,String> convertor = new Function() {
        @Override
        public Object apply(Object o) {
            return "Hello";
        }
    };


    Function<String,Integer> second = (String o) -> {

        return 3;
    };


    public void functionTobeCalled(){

        System.out.println(convertor.andThen(second).apply(2));
        System.out.println(supplier.get().getName()) ;
        System.out.println(predicate.test("Hello"));
    }

    Supplier<Student> supplier = () -> new Student();

    Predicate<String> predicate = str -> str.length() > 1 ;

    public static void main(String[] args) {

        new UsingFunctionalInterface().functionTobeCalled();
    }

}
