package dutchFlago1Segregation;

import com.sun.istack.internal.NotNull;

/**
 * Created by dheeraj on 6/7/16.
 */
public class Seg01 {


    //TODO not obvious
    private static void segregate(int[] ints) {
        int start = 0;
        int end = ints.length - 1;

        while (ints[start] == 0 && start < end) {
            start++;
        }
        while (ints[end] == 1 && start < end) {
            end++;
        }

        while (start < end) {
            ints[start] = 0;
            ints[end] = 1;
            start++;
            end--;
        }
    }

    private static void segregateMy(int[] ints) {
        int start = 0;
        int end = ints.length - 1;

        while (start < end) {
            if (ints[start] == 0) {
                start++;
            }
            if (ints[end] == 1) {
                end--;
            }
            if(ints[start] == 1 && ints[end] == 0){
                ints[start] = 0;
                ints[end] = 1;
                start++;
                end--;
            }

        }
    }


    public static void main(String[] strings) {
        int[] ints = new int[]{1, 1, 1, 0, 0, 0,1};
        segregateMy(ints);
        for (int k : ints) {
            System.out.print(k + " ");
        }
    }
}
