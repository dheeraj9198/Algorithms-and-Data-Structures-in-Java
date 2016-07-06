package DP;

/**
 * Created by dheeraj on 6/7/16.
 * Given a list of 'N' coins, their values being in an array A[], return the minimum number of coins required to
 * sum to 'S' (you can use as many coins you want). If it's not possible to sum to 'S', return –1
 * Input Format
 * First line contains size of array A[] - a_size
 * Next a_size lines contain an integer each denoting the various coin denominations
 * Last line contains an integer 'S'
 * Sample Test Cases
 * Input #00:
 * 3
 * 1
 * 3
 * 5
 * 11
 * Output #00:
 * 3
 * Explanation:
 * Here coin denominations: {1,3,5 } Required sum (S): 
 * The minimum number of coins requires is: 3 - 5 + 5 + 1 = 11;
 */
public class CoinSumDp {

    private static int find(int[] coins, int sum) {
        int sol[] = new int[sum + 1];
        for (int k = 0; k < sol.length; k++) {
            sol[k] = -1;
        }
        sol[0] = 0;
        for (int x = 1; x < sol.length; x++) {
            int d = Integer.MAX_VALUE;
            for (int k = 0; k < coins.length; k++) {
                if(x-coins[k] < 0){
                    continue;
                }
                int min = sol[x-coins[k]];
                if(min != -1){
                    d = Math.min(d,min+1);
                }
            }
            if(d != Integer.MAX_VALUE){
                sol[x] = d;
            }
        }
        return sol[sum];
    }

    public static void main(String[] strings){
        System.out.println(find(new int[]{1,3,5},12));
    }
}
