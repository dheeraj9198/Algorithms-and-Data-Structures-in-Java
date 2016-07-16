package dymanicProgramming;

/**
 * Created by dheeraj on 7/17/2016.
 */
public class SubsetSumProblem {

    private static boolean[][] sol;

    private static Boolean isSubsetSum(int[] set, int sum) {
        for (int x = 0; x < set.length; x++) {
            for (int k = 0; k <= sum; k++) {
                if (set[x] == k) {
                    sol[x][k] = true;
                } else if (x - 1 >= 0 && sol[x - 1][k]) {
                    sol[x][k] = true;
                }
                if (x - 1 >= 0 && sol[x - 1][k] && (k + set[x] <= sum)) {
                    sol[x][k + set[x]] = true;
                }
            }
        }
        return sol[set.length - 1][sum];
    }

    public static void main(String[] strings) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 29;
        sol = new boolean[set.length][sum + 1];
        if (isSubsetSum(set, sum))
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }
}
