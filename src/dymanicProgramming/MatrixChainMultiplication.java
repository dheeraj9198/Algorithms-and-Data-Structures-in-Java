package dymanicProgramming;

/**
 * Created by dheeraj on 7/17/2016.
 */
public class MatrixChainMultiplication {

    private static Integer[][] solMat;

    private static int matrixChainOrderTopDown(int[] ints, int start, int end) {
        if (solMat[start][end] != null) {
            return solMat[start][end];
        }
        int sol = Integer.MAX_VALUE;
        if (start == end) {
            sol = 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int temp = start; temp < end; temp++) {
                int prev = matrixChainOrderTopDown(ints, start, temp);
                int next = matrixChainOrderTopDown(ints, temp + 1, end);
                int current = ints[start - 1] * ints[temp] * ints[end];
                int count = prev + next + current;
                min = Math.min(min, count);
            }
            sol = min;
        }
        solMat[start][end] = sol;
        return sol;
    }

    public static void main(String[] strings) {
        int arr[] = {1, 2, 3, 4};
        solMat = new Integer[arr.length][arr.length];
        System.out.println("Minimum number of multiplications is " + matrixChainOrderTopDown(arr, 1, arr.length - 1));
    }
}
