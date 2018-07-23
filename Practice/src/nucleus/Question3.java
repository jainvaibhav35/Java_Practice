package nucleus;

/**
 * Created by linchpin on 20/4/18.
 */
public class Question3 {

    Question3(){
        System.out.print("In Parent");
    }
}

class childClass extends Question3{

    childClass(){
        System.out.print("In One");
    }

    childClass(int x){
        this();
        System.out.print("In two");
    }

    public static void main(String[] args) {
        childClass cc = new childClass(90);
    }

}
