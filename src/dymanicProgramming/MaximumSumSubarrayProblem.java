package dymanicProgramming;

/**
 * Created by dheeraj on 28/6/16.
 * Maximum subarray problem
 * Largest Sum Contiguous Subarray
 * Kadane's algo
 * <p>
 * def max_subarray(A):
 * max_ending_here = max_so_far = 0
 * for x in A:
 * max_ending_here = max(0, max_ending_here + x)
 * max_so_far = max(max_so_far, max_ending_here)
 * return max_so_far
 * A variation of the problem that does not allow zero-length subarrays to be returned, in the case that the entire array consists of negative numbers, can be solved with the following code:
 * <p>
 * def max_subarray(A):
 * max_ending_here = max_so_far = A[0]
 * for x in A[1:]:
 * max_ending_here = max(x, max_ending_here + x)
 * max_so_far = max(max_so_far, max_ending_here)
 * return max_so_far
 */
public class MaximumSumSubarrayProblem {

    public static void main(String[] strings) {
        int[] data = new int[]/*{-2, 1, -3, 4, -1, 2, 1, -5, 4}*/{-2, -3, 4, -1, -2, 1, 5, -3};

        int overall = 0;
        int current = 0;

        int start = 0;
        int end = 0;

        for (int k = 0; k < data.length; k++) {
            int current1 = Math.max(current + data[k], 0);
            if (current == 0 && current1 > current) {
                start = k;
            }
            current = current1;
            int overall1 = Math.max(overall, current);
            if (overall1 > overall) {
                overall = overall1;
                if (start <= k) {
                    end = k;
                }
            }
        }
        System.out.println(overall+"*"+start+"*"+end);
    }

}
