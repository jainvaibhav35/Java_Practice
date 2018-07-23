package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by linchpin on 27/4/18.
 */
public class ThreadA extends Thread {

//    ThreadA threadA = new ThreadA();

    public static void main(String[] args) {

        ThreadB threadB = new ThreadB();
        ThreadA a = new ThreadA();
        a.setPriority(10);
        a.start();
        threadB.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Run of A inside");
            sleep(10000);
            System.out.println("Run of A");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
