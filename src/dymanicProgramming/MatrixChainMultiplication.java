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


    private static int bottomUp(Integer[][] ints, int[] arr) {
        for (int k = 1; k < ints.length; k++) {
            ints[k][k] = 0;
        }
        for (int end = 2; end < ints[0].length; end++) {
            int startTemp = 1;
            for (int endTemp = end; endTemp < ints[0].length; endTemp++) {
                int min = Integer.MAX_VALUE;
                for (int k = startTemp; k < endTemp; k++) {
                    int current = arr[startTemp - 1] * arr[k] * arr[end];
                    int count = ints[startTemp][k] + ints[k + 1][endTemp] + current;
                    min = Math.min(min, count);
                }
                ints[startTemp][end] = min;
                startTemp++;
            }
        }
        return ints[1][arr.length - 1];
    }

    public static void main(String[] strings) {
        int arr[] = {1, 2, 3, 4};
        solMat = new Integer[arr.length][arr.length];
/*
        System.out.println("Minimum number of multiplications is " + matrixChainOrderTopDown(arr, 1, arr.length - 1));
*/

        System.out.println("Minimum number of multiplications is " + bottomUp(solMat,arr));

    }
}
