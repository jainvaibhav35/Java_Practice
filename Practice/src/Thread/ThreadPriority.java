package Thread;

/**
 * Created by linchpin on 15/5/18.
 */
public class ThreadPriority {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            b.setPriority(10);
            b.start();
            b.join();
            for (int i = 0; i < 10; i++) {
                System.out.println("Main");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
