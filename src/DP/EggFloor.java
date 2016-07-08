package DP;

import java.util.Arrays;

/**
 * Created by dheeraj on 8/7/16.
 */
public class EggFloor {

    private static int[][] sol;

    private static int trails(int eggs, int floors) {
        if (sol[eggs][floors] != Integer.MAX_VALUE) {
            return sol[eggs][floors];
        }
        int ans = Integer.MAX_VALUE;
        if (eggs == 1) {
            //drop from each floor
            ans =  floors;
        }else if (floors == 0 || floors == 1) {
            ans =  floors;
        }else {
            for (int x = 1; x < floors; x++) {
                int broken = trails(eggs - 1, x - 1);
                int unbroken = trails(eggs, floors - x);
                ans = Math.min(ans, Math.max(broken, unbroken));
            }
            ans = ans+1;
        }
        sol[eggs][floors] = ans;
        return ans;
    }

    public static void main(String[] strings) {
        int floors = 10;
        int eggs = 2;
        sol = new int[eggs+1][floors + 1];
        for(int x =0;x<=eggs;x++)
        Arrays.fill(sol[x], Integer.MAX_VALUE);

        trails(eggs, floors);
        System.out.println(sol[eggs][floors]);
    }

}
