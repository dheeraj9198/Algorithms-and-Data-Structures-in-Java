package reloaded2016;

/**
 * Created by dheeraj on 6/30/2016.
 */
public class NthFibo {

    static int nth(int n){
        int first =1;
        int second = 1;
        int x=1;
        for(int k =0;k<n-2;k++){
            x = first+second;
            first = second;
            second = x;
        }
        return x;
    }

    public static void main(String[] strings){
        System.out.println(/*nth(10)*/(int)'A');
    }


}
