package CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dheeraj on 12/16/14.
 */
class AlokNath {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        for (int z = 0; z < testCases; z++) {
            String[] inputStrings = bufferedReader.readLine().split(" ");
            String[] sanskarStrings = bufferedReader.readLine().split(" ");
            int sanskars = Integer.parseInt(inputStrings[0]);
            int persons = Integer.parseInt(inputStrings[1]);

            int[] perTotal = new int[persons];
            int[] sanskarsArray = new int[sanskars];
            for (int x = 0; x < persons; x++) {
                perTotal[x] = 0;
            }

            for (int k = 0; k < sanskarStrings.length; k++) {
                sanskarsArray[k] = Integer.parseInt(sanskarStrings[k]);
            }

            MergeSort mergeSort = new MergeSort(sanskarsArray);
            mergeSort.mergeSort();


            int minIndex;
            for(int l=0;l<sanskarsArray.length;l++){
                minIndex = findMinIndex(perTotal);
                perTotal[minIndex] = perTotal[minIndex] + sanskarsArray[l];
            }

            if(passes(perTotal)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }

    }

    private static boolean passes(int[] array){
        for(int x =1;x<array.length;x++){
           if(array[x-1] != array[x]){
               return false;
           }
        }
        return true;
    }

    private static int findMinIndex(int[] array){
        int minIndex = 0;
        for(int l =1;l<array.length;l++){
            if(array[minIndex] > array[l]){
                minIndex = l;
            }
        }
        return minIndex;
    }

    static class MergeSort {

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
                int mid = (start + end) / 2;
                mergeSortPrivate(start, mid);
                mergeSortPrivate(mid + 1, end);

                for (int x = start; x <= end; x++) {
                    tempArray[x] = array[x];
                }

                int m = start;
                int n = mid + 1;

                int k = start;

                while (m <= mid && n <= end) {
                    if (tempArray[m] > tempArray[n]) {
                        array[k] = tempArray[m];
                        m++;
                        k++;
                    } else {
                        array[k] = tempArray[n];
                        n++;
                        k++;
                    }
                }
                while (m <= mid) {
                    array[k] = tempArray[m];
                    m++;
                    k++;
                }
                while (n <= end) {
                    array[k] = tempArray[n];
                    n++;
                    k++;
                }

            }
        }

    }
}
