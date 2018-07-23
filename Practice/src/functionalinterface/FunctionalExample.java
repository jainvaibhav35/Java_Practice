package functionalinterface;

/**
 * Created by linchpin on 17/7/18.
 */

@FunctionalInterface
public interface FunctionalExample {

    public void sample();

    default public void sample1(){

        System.out.println("Hello Moto");
    }



    default public void sample2(){

        System.out.println("Hello Moto");
    }

     static void sample3(){
        System.out.println("Hello static");
    }

    static void sample4(){
        System.out.println("Hello static");
    }


}
