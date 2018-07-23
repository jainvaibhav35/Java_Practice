package shrishdoubts;

/**
 * Created by Vaibhav Jain on 27/4/18.
 */
public class Parent {

    public static void main(String[] args) {
        Parent p = new Child();
        p.main();
    }

    public void main(){
        System.out.println("Parent class want to send data in child");
        ((Child)this).sendData();
    }
}
