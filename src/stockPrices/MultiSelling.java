package stockPrices;

/**
 * Created by dheeraj on 15/2/15.
 */
public class MultiSelling {
    int[] array;

    private MultiSelling(int[] arr) {
        array = arr;
    }

    private void findPoints() {
        int k = 0;
        int min;
        int max;
        while (k < array.length) {
            min = findMin(k);
            if(min == -1){
                return;
            }
            k = min;
            max = findMax(k);
            if(max == -1){
                return;
            }
            k = max;
            System.out.println("buy : " + min + " sell :" + max);
        }
    }

    private int findMin(int k) {
        for (int j = k; j < array.length; j++) {
            if (j == 0) {
                if (array[j] < array[j + 1]) {
                    return j;
                }
            }else if( j == array.length -1){
                if (array[j] < array[j - 1]) {
                    return j;
                }
            }
            else {
                if (array[j - 1] > array[j] && array[j] < array[j + 1]) {
                    return j;
                }
            }
        }
        return -1;
    }

    private int findMax(int k) {
        for (int j = k; j < array.length; j++) {
            if (j == array.length-1) {
                if (array[j] > array[j -1]) {
                    return j;
                }
            } else if(j == 0){
                if(array[j] > array[j+1]){
                    return j;
                }
            }
            else {
                if (array[j - 1] < array[j] && array[j] > array[j + 1]) {
                    return j;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {100, 180, 260, 310, 40, 535, 695};
        MultiSelling multiSelling = new MultiSelling(array);
        multiSelling.findPoints();
    }

}
