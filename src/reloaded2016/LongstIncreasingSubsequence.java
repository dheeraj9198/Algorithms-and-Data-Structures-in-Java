package reloaded2016;

import java.util.*;

/**
 * Created by dheeraj on 6/11/2016.
 */
public class LongstIncreasingSubsequence {

    private static int[] lis;

    private static int findLis(int[] array, int end) {
        if (end == 0) {
            return 1;
        } else {
            int k = lis[end - 1] == 0 ? findLis(array, end - 1) : lis[end - 1];
            lis[end - 1] = k;
            int x = 0;
            for (int j = 0; j <= end - 1; j++) {
                if (array[j] < array[end]) {
                    x = x > lis[j] ? x : lis[j];
                }
            }
            return 1 + x;
        }
    }

    public static void main(String[] strings) {
        int[] A = {1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2};
        lis = new int[A.length];
        findLis(A, A.length - 1);
        int r = 0;
        for (int k = 0; k < lis.length; k++) {
            if (lis[k] > r) {
                r = lis[k];
            }
        }
        System.out.println(r);
        int largest = r;
        int index = A.length-1;
        while(index >=0){
            if( lis[index] == largest) {
                System.out.print(A[index] + " ");
                largest--;
            }
            index = index-1;

        }
    }


}
