package sorting;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by dheeraj on 6/1/15.
 */
public class MergeSort {

    private static int[] temp;

    private static void mergeSort(int[] arr, int start, int end) {

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        int x = start;
        int y = mid + 1;
        int tempIndex = start;

        while (x <= mid && y <= end) {
            if (arr[x] < arr[y]) {
                temp[tempIndex] = arr[x];
                tempIndex++;
                x++;
            } else {
                temp[tempIndex] = arr[y];
                tempIndex++;
                y++;
            }
        }

        while (x <= mid) {
            temp[tempIndex] = arr[x];
            tempIndex++;
            x++;
        }


        while (y <= end) {
            temp[tempIndex] = arr[y];
            tempIndex++;
            y++;
        }

        for(int xx =start;xx<=end;xx++ ){
            arr[xx] = temp[xx];
        }
    }

    public static void main(String[] args){
        int[] array = {5,4,3,2,1,9,8,7,6,5,4,3};
        temp = new int[array.length];
        for(int x =0;x< array.length;x++){
            System.out.print(array[x]+ " ");
        }
        System.out.println();

        mergeSort(array, 0, array.length - 1);

        for(int x =0;x< array.length;x++){
            System.out.print(array[x]+ " ");
        }
        System.out.println();
    }

}
