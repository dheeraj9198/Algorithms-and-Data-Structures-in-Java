package dymanicProgramming;

/**
 * Created by dheeraj on 7/10/2016.
 */
public class KnapsackProblem {

    //10 -> 60
    //20 -> 100
    //30 -> 120

    static int knapSack(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return Math.max(val[n] + knapSack(W - wt[n], wt, val, n-1),
                knapSack(W, wt, val, n-1)
        );
    }

    public static void main(String[] strings) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        int n = val.length-1;
        System.out.println(knapSack(W, wt, val, n));
    }
}
