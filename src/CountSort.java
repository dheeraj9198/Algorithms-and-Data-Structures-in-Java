/**
 * Created by dheeraj on 12/18/14.
 */
public class CountSort {
    int[] array;
    int arrayLength;
    int maxValue;

    private int findMaxValue(int[] arr){
        int max = arr[0];
        for(int k =1;k<arr.length;k++){
            if(max < arr[k]){
                max = arr[k];
            }
        }
    return max;
    }

    public CountSort(int[] array){
        this.array = array;
        this.arrayLength = array.length;
        this.maxValue = findMaxValue(array)+1;
    }

    public int[] sort(){
        int[] hashArray = new int[maxValue];
        int[] resultArray = new int[arrayLength];
        for(int a =0;a<maxValue;a++){
            hashArray[a]=0;
        }

        for(int a=0;a<arrayLength;a++){
            hashArray[array[a]] = hashArray[array[a]] + 1;
        }

        for(int a=1;a<maxValue;a++){
            hashArray[a] = hashArray[a] + hashArray[a-1];
        }

        for(int a = arrayLength-1;a>=0;a--){
            hashArray[array[a]] = hashArray[array[a]] -1;
            resultArray[hashArray[array[a]]] = array[a];
        }

        return resultArray;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,1,3,2,5,6};
        CountSort countSort = new CountSort(arr);
        arr = countSort.sort();
        for(int a =0;a<arr.length;a++){
            System.out.println(arr[a]+" ");
        }
    }
}
