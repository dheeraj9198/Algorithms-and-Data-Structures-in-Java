package CoreJava.advancedMultiThreading;

/**
 * Created by dheeraj on 7/18/2016.
 */
public class ThreadRunnableVsRun {

    public static void main(String[] strings) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable run called");
            }
        }) {
            @Override
            public void run() {
                System.out.println("thread run called");
            }
        };
        t.start();
    }

}
