package stockPrices;

/**
 * Created by dheeraj on 12/2/15.
 */
public class DivideAndConquerNLOGN {

    private int[] array;

    private DivideAndConquerNLOGN(int[] a) {
        array = a;
    }

    private int maxProfit() {
        return recursion(0, array.length - 1);
    }

    private int recursion(int start, int end) {
        System.out.println("start  = " + start + " end  = " + end);
        if (start + 1 == end) {
            // only 2 elements
            if(array[end] >= array[start]){
                return array[end] - array[start];
            }else{
                return 0;
            }
        } else {
            int mid = start + (end - start) / 2;
            int leftProfit = recursion(start, mid);
            int rightProfit = recursion(mid, end);


            /**
             * O(n) searches => T(n) = 2T(n/2)  + O(n) => O(nlogn)
             */
            int min = findMinIndex(start, mid);
            int max = findMaxIndex(mid, end);

            int profit = array[max] - array[min];

            if (leftProfit > profit && leftProfit > rightProfit) {
                return leftProfit;
            } else if (rightProfit > profit && rightProfit > leftProfit) {
                return rightProfit;
            } else {
                return profit;
            }
        }
    }

    private int findMinIndex(int start, int end) {
        int min = start;
        for (int k = start + 1; k <= end; k++) {
            min = array[min] > array[k] ? k : min;
        }
        return min;
    }

    private int findMaxIndex(int start, int end) {
        int max = start;
        for (int k = start + 1; k <= end; k++) {
            max = array[max] < array[k] ? k : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 3, 2, 9, 2, 5, 4, 2, 100,1000,0};
        DivideAndConquerNLOGN divideAndConquer = new DivideAndConquerNLOGN(array);
        System.out.println(divideAndConquer.maxProfit());
    }

}
