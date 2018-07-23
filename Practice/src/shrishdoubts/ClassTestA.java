package shrishdoubts;

/**
 * Created by linchpin on 3/7/18.
 */
public class ClassTestA {

    public void methodA() {
        try {
            for (int i = 0; i < 50; i++) {
                System.out.println(i);
                Thread.sleep(10);

                synchronized (this) {

                    notifyAll();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
