package CoreJava;

/**
 * Created by sujeet on 30/12/14.
 */
public class A {
    public String data;

    public void test(String data){
        this.data = data;
    }

    private A()
    {
        this.data = "pri";
    }
}
