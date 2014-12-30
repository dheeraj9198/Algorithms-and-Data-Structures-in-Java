package CoreJava;

/**
 * Created by sujeet on 30/12/14.
 */
public class B extends A{

   public B(){
   }

   public void print(){
       System.out.println(data);
   }

    private void test(String data){
        this.data = data;
    }

    public static void main(String[] args){
        B b = new B();
        b.print();
    }

}
