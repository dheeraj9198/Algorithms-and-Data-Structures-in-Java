import java.util.Arrays;

/**
 * Created by dheeraj on 6/7/16.
 * Given an array of integers. Remove minimum number of elements from the array such that the largest and the smallest number does
 * not differ by more than two times.In other words if x is the minimum of the remaining elements in the array and y is the maximum than y<=2x.
 * Find the minimum number of numbers that has to be removed from the array so that the largest and the smallest number differed in no more than two times.
 * Input:
 * First line contains n(2<=n<=10^5), the size of the array
 * Second line contains n integers, the elements of the array.
 * Output:
 * Single integer - the minimum number of elements to be removed from the array.
 * Sample Test Case:
 * Input: {4,5,3,8,3,7}
 * Output: 2
 * Note: In the above sample you can remove the fourth and the sixth measurement results (values 8 and 7).
 * Then the maximum of the remaining values will be 5, and the minimum one will be 3. Or else, you can remove the third and fifth results (both equal 3).
 * After that the largest remaining result will be 8, and the smallest one will be 4.
 * You do not need to write full code. Just fill out the given function.
 */
public class AmazonTestRemoveArrayElems {

    //  1 3 3 4 5 7 8
    static int minIndex = -1;

    private static void findHalf(int[] ints, int max, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        if (2 * ints[mid] >= max) {
            minIndex = mid;
            findHalf(ints, max, start, mid - 1);
        } else {
            findHalf(ints, max, mid + 1, end);
        }
    }

    public static void main(String[] strings) {
        System.out.println(minArray(new int[]{3,3,3,3,1, 4, 5, 3, 8, 3, 7}));
    }

    private static int minArray(int[] arr) {
        Arrays.sort(arr);
        int sol = -1;
        findHalf(arr,arr[arr.length-1],0,arr.length-1);
        sol = minIndex;
     /*   int max = arr[arr.length - 1];

        for (int k = 0; k < arr.length; k++) {
            if (2 * arr[k] <= max) {
                sol = k;
            }
        }*/

        int sol2 = -1;
        for (int k = arr.length - 1; k >= 0; k--) {
            if (2 * arr[0] <= arr[k]) {
                sol2 = k;
            }
        }

        if (sol2 != -1)
            sol2 = arr.length - 1 - sol2;

        if (sol == -1 && sol2 == -1) {
            return 0;
        } else {
            return Math.min(sol, sol2);
        }

    }
}
