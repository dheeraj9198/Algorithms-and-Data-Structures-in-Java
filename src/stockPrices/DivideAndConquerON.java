package stockPrices;

/**
 * Created by dheeraj on 12/2/15.
 */
public class DivideAndConquerON {

    private int[] array;

    private DivideAndConquerON(int[] a) {
        array = a;
    }

    private int maxProfit() {
        return recursion(0, array.length - 1).profit;
    }

    private Result recursion(int start, int end) {
        System.out.println("start  = " + start + " end  = " + end);
        if (start + 1 == end) {
            if(array[start] <= array[end]){
                return new Result(array[end]-array[start],start, end);
            }else{
                return new Result(0,end,start);
            }
        } else {
            int mid = start + (end - start) / 2;
            Result left = recursion(start, mid);
            Result right = recursion(mid, end);


            /**
             * O(1) min/max => T(n) = 2T(n/2)  + O(1) => O(n)
             */

            if(array[left.minIndex] <= array[right.minIndex] && array[left.maxIndex] <= array[right.maxIndex]
                    && (array[right.maxIndex] - array[left.minIndex]) > Math.max(left.profit,right.profit)){
                    return new Result(array[right.maxIndex] - array[left.minIndex],left.minIndex,right.maxIndex);
            }else if(left.profit > right.profit){
                return left;
            }else{
                return right;
            }
        }
    }

    private class Result {
        private int profit;
        private int minIndex;
        private int maxIndex;

        public Result(int profit, int minIndex, int maxIndex) {
            this.profit = profit;
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }
    }


    public static void main(String[] args) {
        int[] array = {7, 1, 3, 2, 9, 2, 5, 4, 2, 100,1000,2};
        DivideAndConquerON divideAndConquer = new DivideAndConquerON(array);
        System.out.println(divideAndConquer.maxProfit());
    }

}
