package CoreJava.arrayListVsVector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by dssachan on 29/09/16.
 * shows how to cause a ConcurrentModificationException
 */
public class VectorTest {

    private static Vector<Integer> ints = new Vector<Integer>();

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
            try {
                while (integerIterator.hasNext()) {
                    System.out.println(integerIterator.next());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                Thread.sleep(100);
            }catch (Exception e){}
        }

    }

}
