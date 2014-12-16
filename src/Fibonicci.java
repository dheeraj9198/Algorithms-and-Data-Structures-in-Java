import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dheeraj on 12/16/14.
 */
public class Fibonicci {
    public static void main(String[] args) throws Exception {
        while (true) {
            int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println(nthFib(x));
        }
    }

    private static int nthFib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        int prev = 1;
        int curr = 1;

        int temp;
        for (int k = 3; k <= x; k++) {
            temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }

}
