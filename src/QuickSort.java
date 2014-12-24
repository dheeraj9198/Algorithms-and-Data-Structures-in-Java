import java.util.Random;

/**
 * Created by dheeraj on 24/12/14.
 */
public class QuickSort {

    private static void quickSort(int [] array){
        quickSortAlgo(array,0,array.length-1);
    }

    private static void quickSortAlgo(int[] array,int start,int end){
        if(start < end){
            int x = partitionRand(array,start,end);
            quickSortAlgo(array, start, x - 1);
            quickSortAlgo(array, x + 1, end);
        }
    }

    private static int partition(int[] array, int start,int end){
        // last element is pivot
        int pivotData = array[end];
        int index = start;
        int temp;
        for(int x = start;x<=end-1;x++){
            if(array[x] < pivotData){
                temp = array[x];
                array[x] = array[index];
                array[index] = temp;
                index++;
            }
        }
        array[end] = array[index];
        array[index]=  pivotData;
        return index;
    }


    private static int partitionRand(int[] array, int start,int end){
        Random r = new Random();
        int R = r.nextInt(end-start) + start;
        // last element is pivot
        int temp;

        temp = array[R];
        array[R] = array[end];
        array[end] = temp;

        int pivotData = array[end];
        int index = start;
        for(int x = start;x<=end-1;x++){
            if(array[x] < pivotData){
                temp = array[x];
                array[x] = array[index];
                array[index] = temp;
                index++;
            }
        }
        array[end] = array[index];
        array[index]=  pivotData;
        return index;
    }

    public static void main(String[] args){
        int[] arr = {3,7,8,5,2,1,9,5,4};//{1,2,4,3,5,6,8,7,9,10,34};
        quickSort(arr);
        for(int g =0;g<arr.length;g++){
            System.out.println(arr[g]+" ");
        }
    }

}
