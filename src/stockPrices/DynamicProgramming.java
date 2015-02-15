package stockPrices;

/**
 * Created by dheeraj on 15/2/15.
 */
public class DynamicProgramming {

    private int[] array;

    private DynamicProgramming(int[] ar){
        array = ar;
    }

    private int maxProfit(){
        int minIndex = 0;
        int maxIndex = 0;
        int profit = 0;

        for(int k = 1;k<array.length;k++){
            if(array[k] < array[minIndex]){
                minIndex = k;
                profit = array[maxIndex] - array[minIndex];
            }
            if(array[k] > array[maxIndex]){
                maxIndex = k;
                profit = array[maxIndex] - array[minIndex];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 3, 2, 9, 2, 5, 4, 2, 100,1000,2};
        DynamicProgramming dynamicProgramming = new DynamicProgramming(array);
        System.out.println(dynamicProgramming.maxProfit());
    }
}
