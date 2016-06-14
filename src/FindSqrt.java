/**
 * Created by dheeraj on 14/6/16.
 */
public class FindSqrt {

    public static void main(String[] strings) {

        int num = 10000;
        System.out.println(sqrt(num, 0, num));
    }

    private static int sqrt(int num, int min, int max) {
        int middle = (min + max) / 2;
        int x = middle * middle;
        if (x == num) {
            return middle;
        } else if (x < num) {
            return sqrt(num, middle, max);
        } else {
            return sqrt(num, min, middle);
        }
    }
}
