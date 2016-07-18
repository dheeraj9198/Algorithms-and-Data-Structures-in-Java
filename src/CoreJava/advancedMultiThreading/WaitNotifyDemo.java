package CoreJava.advancedMultiThreading;

/**
 * Created by dheeraj on 7/18/2016.
 */
public class WaitNotifyDemo {

    public static void main(String[] strings) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (WaitNotifyDemo.class) {
                    try {
                        WaitNotifyDemo.class.wait();
                    } catch (Exception e) {
                    }
                    System.out.print("waiting done");
                }
            }
        }).start();
        Thread.sleep(1000);


        //above thread will only be notified after this syn is released after wait of 4 seconds
        synchronized (WaitNotifyDemo.class) {
            WaitNotifyDemo.class.notify();
            System.out.println("notified");
            Thread.sleep(4000);
        }
    }


}
