package LeetCode;

/**
 * Created by dheeraj on 26/1/15.
 * Given n non-negative integers representing an
 * elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p/>
 * https://oj.leetcode.com/problems/trapping-rain-water/
 */
public class TrappingWater {

    private int findMax(int[] array,int index){
        int max  = index;
        for(int k = index+1;k<array.length;k++){
            max = array[max] >array[k] ? max : k;
        }
        return  max;
    }

    public int trap(int[] A) {
        int ans =0 ;
        int k =0;
        while (k<A.length-1){
            if(A[k+1] > A[k]){
                k = k+1;
            }else{
                int p = 0;
                for(int j = k+1;j<A.length;j++){
                    if(A[j] < A[k]){
                        if(j == A.length-1){
                            A[k] = A[findMax(A,k+1)];
                            break;
                        }
                        p = p + A[k] - A[j];
                    }else{
                        ans = ans+p;
                        k = j;
                        break;
                    }
                }
            }
        }
    return ans;
    }

    public static void main(String[] args){
        int[] arr = {4,2,3};//{0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingWater trappingWater = new TrappingWater();
        System.out.println(trappingWater.trap(arr));
    }





}


