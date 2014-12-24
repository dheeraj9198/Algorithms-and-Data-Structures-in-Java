package DP;

/**
 * Created by dheeraj on 12/24/14.
 * For a better understanding let's take this example:
 * Given coins with values 1, 3, and 5.
 * And the sum S is set to be 11.
 */

public class Beginner_CoinsSum {

    public static void main(String[] args){
        // 1, 3 , 5
        System.out.println(findMinCoins(11));
    }

    public static int findMinCoins(int sum){
        if(sum <= 0){
            return Integer.MAX_VALUE;
        }
        if(sum == 1 || sum == 5 || sum ==3){
            return 1;
        }
        return 1+minimum(findMinCoins(sum-1),findMinCoins(sum -3),findMinCoins(sum-5));
    }

    public static int minimum(int x,int y,int z){
        if(x <= y && x <= z){
            return x;
        }else if(y <= z){
            return y;
        }else{
            return x;
        }
    }
}
