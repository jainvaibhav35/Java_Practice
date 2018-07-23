import java.io.Serializable;

public class ChildSerialization extends Serialization {

    public void fun(){
        System.out.println("class child");
    }

    public static void main(String args[]){
        Serialization s = new ChildSerialization();
        s.fun();
        ((ChildSerialization)s).sampleEnumCall();
    }

    public void sampleEnumCall() {
        SignletonExample se = SignletonExample.INSTANCE;
        se.method();
    }



}
