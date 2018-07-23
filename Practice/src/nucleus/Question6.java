package nucleus;

/**
 * Created by linchpin on 20/4/18.
 */
public class Question6 extends B{

        protected Question6(){
            this.printA();
            this.printB();
        }

    public static void main(String[] args) {
        new Question6().printA();
    }
    }

    abstract class B extends A{

    public void printA(){
        System.out.print("Class B");
    }

    }


abstract class A{

    public void printB(){
        System.out.print("Class A");
    }

}
