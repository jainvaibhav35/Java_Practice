package Thread;

/**
 * Created by linchpin on 29/5/18.
 */
public class ThreadGp {
    public static void main(String[] args) {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread t[] = new Thread[system.activeCount()];
        system.enumerate(t);
        for (Thread thread : t) {
            System.out.println(thread.getName() + " is Deamon " + thread.isDaemon());
        }
    }
}
