package CoreJava.arrayListVsVector;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Vector;
import java.lang.System;
/**
 * Created by dssachan on 29/09/16.
 */
public class TimeTest {
    static PrintStream ps = System.out;
    public static void main(String[] strings){
        ArrayList iA = new ArrayList();
        Vector iV = new Vector();
        Integer integer = new Integer(100);
        long t1 = System.nanoTime();
        for(int k =0;k<100000;k++) {
                iA.add(integer);
            }
        ps.println(iA);
        ps.println();
        ps.println(System.nanoTime() - t1);
        t1 = System.nanoTime();
        for(int k =0;k<100000;k++) {
            iV.add(integer);
        }
        ps.print(iV.toString());
        ps.println();
        ps.println(System.nanoTime() - t1);
    }
}
