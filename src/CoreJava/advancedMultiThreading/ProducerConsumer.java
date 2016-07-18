package CoreJava.advancedMultiThreading;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by dheeraj on 7/18/2016.
 */
public class ProducerConsumer {

    private static final int size = 10;
    private static LinkedList<Integer> queue = new LinkedList<Integer>();
    private static Object lock = new Object();
    private static Random random = new Random();

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (queue.size() == size) {
                        try {
                            System.out.println("queue full");
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(random.nextInt());
                    lock.notifyAll();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                synchronized (lock) {
                    while (queue.size() == 0) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(queue.pollFirst() + " size  = " + queue.size());
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] strings) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();

    }


}
