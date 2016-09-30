package CoreJava.arrayListVsVector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by dssachan on 29/09/16.
 * shows how to cause a ConcurrentModificationException
 */
public class ArrayListTest {

    private static ArrayList<Integer> ints = new ArrayList<Integer>();

    public static void main(String[] strings) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ints.add(new Random().nextInt());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ints.add(new Random().nextInt());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ints.add(new Random().nextInt());
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        System.out.println("started");

        try {
            Thread.sleep(5000);
        }catch (Exception e){}

        Iterator<Integer> integerIterator = ints.iterator();
        while(true) {
            while (integerIterator.hasNext()) {
                System.out.println(integerIterator.next());
            }
            try{
                Thread.sleep(100);
            }catch (Exception e){}
        }

    }

}
