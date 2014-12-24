/**
 * Created by sujeet on 24/12/14.
 */
public class QuickSort {

    private static void quickSort(int [] array){
        quickSortAlgo(array,0,array.length-1);
    }

    private static void quickSortAlgo(int[] array,int start,int end){
        if(start < end){
            int x = partition(array,start,end);
            quickSortAlgo(array, start, x - 1);
            quickSortAlgo(array, x + 1, end);
        }
    }

    private static int partition(int[] array, int start,int end){
        int temp;
        int x = start;
        int endData = array[end];
        for(int k =0;k<end;k++){
            if(array[k]<endData){
                temp = array[k];
                array[k]=array[x];
                array[x]=temp;
                x++;
            }
        }
        array[end]=array[x];
        array[x]=endData;
        return x;
    }

    public static void main(String[] args){
        int[] arr = {1,2,4,3,5,6,8,7,9,10,34};
        quickSort(arr);
        for(int g =0;g<arr.length;g++){
            System.out.println(arr[g]+" ");
        }
    }

}
