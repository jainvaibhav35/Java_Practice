package functionalinterface;

import java.util.function.Function;

/**
 * Created by linchpin on 19/7/18.
 */
public class FunctionFunctionalInterface {

    Function<Integer,String> function = new Function<Integer, String>() {
        @Override
        public String apply(Integer integer) {
            return "This is Function Functional Interface";
        }
    };

    public void method(){
        System.out.println(function.apply(3));
    }

    public static void main(String[] args) {
        new FunctionFunctionalInterface().method();
    }

}
