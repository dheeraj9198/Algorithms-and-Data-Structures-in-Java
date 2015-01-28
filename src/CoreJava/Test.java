package CoreJava;

import com.sun.java.util.jar.pack.*;

/**
 * Created by dheeraj on 6/1/15.
 */
public class Test {
    static {
        System.out.println("test");
    }

    public static void main(String[] args)throws  ClassNotFoundException{
        System.out.println("main");
        Class.forName("CoreJava.DS");
        String s = DS.class.getName();
    }
}
