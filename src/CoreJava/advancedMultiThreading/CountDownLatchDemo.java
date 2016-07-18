package CoreJava.advancedMultiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dheeraj on 7/18/2016.
 */
public class CountDownLatchDemo {

    static class Task implements Runnable {

        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                countDownLatch.countDown();
                countDownLatch.await();
                System.out.println("done waiting " + Thread.currentThread().getName());
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] strings) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int k = 0; k < 3; k++) {
            Thread thread = new Thread(new Task(countDownLatch));
            thread.setName("num " + k);
            thread.start();
        }
    }
}
