package CoreJava.advancedMultiThreading;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by dheeraj on 7/18/2016.
 */

public class CyclicBarrierDemo {

    static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                cyclicBarrier.await();
                System.out.println("done waiting "+Thread.currentThread().getName());
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] strings){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        for(int k=0;k<3;k++){
            Thread thread = new Thread(new Task(cyclicBarrier));
            thread.setName("num "+k);
            thread.start();
        }
    }
}
