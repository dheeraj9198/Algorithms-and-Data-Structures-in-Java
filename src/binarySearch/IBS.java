package binarySearch;

import java.util.Arrays;

/**
 * Created by dssachan on 17/08/16.
 */
public class IBS {

    private static int ibs(int[] ints, int data) {
        int start = 0;
        int end = ints.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (ints[mid] == data) {
                return mid;
            } else if (ints[mid] < data) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    

    public static void main(String[] args) {
        System.out.println(ibs(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 9));
    }

}
