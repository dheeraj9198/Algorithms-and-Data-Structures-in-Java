import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/19/14
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {
    public static void main(String[] args) throws Exception
    {
        int number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(fibonacci(number));

    }

    public static int fibonacci(int num)
    {
        if(num ==0 )return 0;
        else if(num ==1 )return 1;
        else return fibonacci(num -1) + fibonacci(num - 2);
    }

}
