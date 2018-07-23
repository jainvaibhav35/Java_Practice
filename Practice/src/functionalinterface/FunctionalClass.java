package functionalinterface;

/**
 * Created by linchpin on 17/7/18.
 */

interface I{
    public void imple();
}
interface J{
    public void imple(int a);
}


public class FunctionalClass {

    public void a(){
        System.out.println("Hello");
    }




    public static void main(String[] args) {

    I i = ()-> System.out.println("Hello vaibhav") ;
    i.imple();

    }




}
