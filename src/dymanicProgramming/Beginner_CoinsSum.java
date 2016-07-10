package dymanicProgramming;

import java.util.Hashtable;

/**
 * Created by dheeraj on 12/24/14.
 * For a better understanding let's take this example:
 * Given coins with values 1, 3, and 5.
 * And the sum S is set to be 11.
 */

public class Beginner_CoinsSum {

    public static Hashtable<Integer,Integer> lookupTable  = new Hashtable<Integer, Integer>();
    public static int calc = 0;

    public static void main(String[] args){
        // 1, 3 , 5
        System.out.println(findMinCoinsBottomUp(11)+" "+calc);
    }

    public static int findMinCoinsTopDown(int sum){
        if(lookupTable.containsKey(sum)){
            return lookupTable.get(sum);
        }
        calc++;
        if(sum <= 0){
            return Integer.MAX_VALUE;
        }
        if(sum == 1 || sum == 5 || sum ==3){
            return 1;
        }
        int ans =1+minimum(findMinCoinsTopDown(sum-1),findMinCoinsTopDown(sum -3),findMinCoinsTopDown(sum-5));
        lookupTable.put(sum,ans);
        return ans;
    }

    public static int findMinCoinsBottomUp(int sum){
        if(sum <= 0){
            return Integer.MAX_VALUE;
        }
        lookupTable.put(1,1);
        lookupTable.put(3,1);
        lookupTable.put(5,1);

        for(int x =1;x<=sum;x++){
            if(lookupTable.containsKey(x)){
                continue;
            }else{
                lookupTable.put(sum,1+minimum(findMinCoinsBottomUp(sum-1),findMinCoinsBottomUp(sum-3),findMinCoinsBottomUp(sum-5)));
            }
        }
        return lookupTable.get(sum);
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
