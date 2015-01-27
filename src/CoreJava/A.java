package CoreJava;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by sujeet on 30/12/14.
 */
public class A {
    public String data;

    public void test(String data){
        this.data = data;
        ConcurrentMap<Integer,Integer> integerIntegerConcurrentMap = new ConcurrentHashMap<Integer, Integer>();
    }

    private A()
    {
        this.data = "pri";
    }
}
