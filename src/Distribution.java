import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/30/14
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
class Distribution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] test = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(test[0]);
        int R = Integer.parseInt(test[1]);

        if (N < R) {
            System.out.println(-1);
            return;
        } else if (N == R) {
            System.out.println(1);
            return;
        }


        long product = 1L;


        for (long k = 2L; k <= N - 1; k++) {
            if ((N - R + 1 <= k && k <= N - 1) && (2 <= k && k <= R - 1)) {
                continue;
            } else if ((N - R + 1 <= k && k <= N - 1)) {
                product = (product*k);
                continue;
            } else if((2 <= k && k <= R - 1)){
                product = product / k;
                continue;
            }
        }
            product = product % 10000007 ;
      /*  for(int x = N-R+1;x<= N-1;x++)
        {
            product = (product * x) ;
        }

        for(int y = 2;y <= R-1;y++)
        {
             product = product /y;
        }*/
    System.out.println(product);
}

}
