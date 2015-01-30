package CoreJava;

/**
 * Created by dheeraj on 28/1/15.
 */
public class ABSA extends ABS{
    @Override
    public void go() {
        test = 10;
        System.out.print(test);
    }

    public static void main(String[] args){
        ABSA absa = new ABSA();
        absa.go();
    }
}
