package Array;

/**
 * Created by dheeraj on 6/28/2016.
 */
public class MaxElementInRight {

    public static void main(String[] strings) {
        int[] ints = new int[]{4, 5, 2, 25};
        int result = -1;

        for (int k = ints.length - 1; k >= 0; k--) {
            if (k == ints.length - 1) {
                result = -1;
            } else {
                result = Math.max(result, ints[k + 1]);
            }
            System.out.println(result);
        }
    }
}
