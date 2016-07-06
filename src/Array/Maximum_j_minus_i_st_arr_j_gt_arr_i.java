package Array;

/**
 * Created by dheeraj on 7/7/2016.
 * Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
 */
public class Maximum_j_minus_i_st_arr_j_gt_arr_i {

    public static void main(String[] strings){
        int[] ints = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};

        int[] min = new int[ints.length];
        int[] max = new int[ints.length];

        int length = ints.length;

        min[0] = ints[0];
        for(int k =1;k<ints.length;k++){
             min[k] = Math.min(min[k-1],ints[k]);
        }

        max[length-1] = ints[length-1];
        for(int k = length-2;k>=0;k--){
            max[k] = Math.max(max[k+1],ints[k]);
        }

        int i=0,j=0;
        int diff = 0;

        while(i<length && j <length){
            if(min[i] < max[j]){
                diff = Math.max(diff,j-i);
                j++;
            }else{
                i++;
            }

        }


        System.out.println(diff);
    }



}
