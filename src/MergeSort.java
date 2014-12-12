/**
 * Created by dheeraj on 12/12/14.
 */
public class MergeSort {

    int[] array;
    int[] tempArray;
    int length;

    public MergeSort(int[] arr) {
        this.array = arr;
        this.length = arr.length;
        this.tempArray = new int[length];
    }

    public void mergeSort() {
        mergeSortPrivate(0, length - 1);
    }

    private void mergeSortPrivate(int start, int end) {

        if (start < end) {
            int mid = (start+end)/2;
            mergeSortPrivate(start, mid);
            mergeSortPrivate(mid+1,end);

            for (int x = start; x <= end; x++) {
                tempArray[x] = array[x];
            }

            int m = start;
            int n = mid+1;

            int k = start;

            while(m<=mid && n <=end){
                if(tempArray[m] < tempArray[n])
                {
                    array[k] = tempArray[m];
                    m++;k++;
                }else{
                    array[k] = tempArray[n];
                    n++;k++;
                }
            }
            while(m<=mid){
                    array[k] = tempArray[m];
                    m++;k++;
            }
            while(n <=end){
                    array[k] = tempArray[n];
                    n++;k++;
            }

        }


    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.mergeSort();


        for (int a = 0; a < arr.length; a++) {
            System.out.print(arr[a] + " ");
        }


    }
}
