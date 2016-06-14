/**
 * Created by dheeraj on 14/6/16.
 * Maximum difference between two elements such that larger element appears after the smaller number
 * Given an array arr[] of integers, find out the difference between any two elements such that larger
 * element appears after the smaller number in arr[].
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2).
 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 */
public class MaxDifference {

    public static void main(String[] args) {
        int[] array = {7, 9, 5, 6, 3, 2};//{2, 3, 10, 6, 4, 8, 1};
        int min = array[0];
        int diff = 0;
        for (int k = 1; k < array.length; k++) {
            if (min > array[k]) {
                min = array[k];
            }
            diff = Math.max(array[k] - min, diff);
        }
        System.out.println(diff);
    }

}
