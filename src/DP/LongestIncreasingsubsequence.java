package DP;

/**
 * Created by dheeraj on 12/25/14.
 */
public class LongestIncreasingsubsequence {

    private int[] array;
    private LongestIncreasingsubsequence(int[] arr){
        array = arr;
    }

    private int solve(){
        int[] solution = new int[array.length];
        for(int x=0;x<array.length;x++){
            solution[x] = 1;
        }

        lis(solution);
        int max = solution[0];
        for(int x=1;x<solution.length;x++){
            if(max < solution[x]){
                max = solution[x];
            }
        }
        return max;
    }

    private void lis(int[] solution){
        for(int x =1;x<array.length;x++){
            for(int y=0;y<x;y++){
                if(array[x] > array[y] && solution[x] < solution[y]+1){
                    solution[x] = solution[y]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {2,5,3,7,11,1};
        LongestIncreasingsubsequence longestIncreasingsubsequence = new LongestIncreasingsubsequence(arr);
        System.out.println(longestIncreasingsubsequence.solve());
    }

}
