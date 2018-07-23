package Thread;

/**
 * Created by linchpin on 27/4/18.
 */
public class ThreadB extends Thread {


        @Override
        public void run () {
        try {
            Thread.currentThread().interrupt();
            for (int i = 0; i < 10; i++) {
                System.out.println("Child");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
