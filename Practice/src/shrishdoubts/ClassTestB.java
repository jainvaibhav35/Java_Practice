package shrishdoubts;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by linchpin on 3/7/18.
 */
public class ClassTestB {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();

        ClassTestA a = new ClassTestA();

        new Thread(() -> {
            synchronized (a) {
                try {
                    System.out.println("First");
                    a.methodA();
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        ).start();

        System.out.println("bjvhjdjk");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
