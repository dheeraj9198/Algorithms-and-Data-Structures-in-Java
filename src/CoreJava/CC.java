package CoreJava;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by dheeraj on 28/1/15.
 */
public class CC  {


    public void no() {
        System.out.println(C.test);
    }

    public CC(){
    }

    public boolean equals(Object obj) {
        return true;
    }

    public int hashCode(){
        return 123456789;
    }

    public static void main(String[] args){

        class test{
            int x =10;
        }

        test a = new test();

        System.out.println(a.x);

        if(true)return;

       int k =9;
        switch (k){
            case (10-1):
                System.out.println(1);
            case  4:
                System.out.println(9);
            case 3:
                System.out.println(3);
                default:
                    System.out.println("none");
        }

        List<Integer> integers = new ArrayList<Integer>();
        integers.listIterator();


        CC c1 = new CC();
        CC c2 = new CC();
        if(c1.hashCode() == c2.hashCode()){
            System.out.print("equal");
        }else{
            System.out.print("not equal");
        }

        /*CC cc = new CC();
        cc.no();

        Map<Integer,Integer>  integerMap = Collections.synchronizedMap(new HashMap<Integer, Integer>());

        String s = "xfxfx";*/
    }
}
