package dymanicProgramming;

/**
 * Created by dheeraj on 12/25/14.
 */
public class MaxSumIncreasingsubsequence {

    private int[] array;
    private MaxSumIncreasingsubsequence(int[] arr){
        array = arr;
    }

    private int solve(){
        int[] solution = new int[array.length];
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
        solution[0] = array[0];
        for(int x =1;x<array.length;x++){
            for(int y=0;y<x;y++){
                if(array[x] > array[y] && solution[x] < solution[y]+array[x]){
                    solution[x] = solution[y]+array[x];
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        MaxSumIncreasingsubsequence maxSumIncreasingsubsequence = new MaxSumIncreasingsubsequence(arr);
        System.out.println(maxSumIncreasingsubsequence.solve());
    }

}
