package CoreJava;

/**
 * Created by sujeet on 30/12/14.
 */
public class B extends A{
    private String data;

    public void test(String data){
        this.data = data;
    }

    public B()
    {
        this.data = "abc";
    }

    private String getIt(){
        return data;
    }

    public static void main(String[] args){
        B b= new B();
        System.out.println(b.getIt());
    }
}
