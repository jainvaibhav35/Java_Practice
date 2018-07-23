package nucleus;

/**
 * Created by linchpin on 20/4/18.
 */
public class Question7 implements Runnable{

    int i = 1;
    @Override
    public void run() {
        System.out.println("running " + i++);
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Question7()) ;
        t.run();
        t.run();
        t.start();
    }
}
