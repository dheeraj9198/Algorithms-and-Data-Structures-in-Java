package CodeChef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dheeraj on 12/16/14.
 *
 */
/*

Alok-nath is man of equality. He needs your help to divide his “sanskars” evenly amongst all his followers. By doing this,
        Alok-nath can create equality amongst his followers and he'll be called a true “sanskari”.
        Alok-nath has N sanskars, and K followers. Each sanskar is given a numerical value which shows its intensity.
        Your task is to determine whether it is possible to allocate all the sanskars to followers in such a way that the sum
        of intensities of the sanskars allocated to each follower is equal. Note : A sanskar can be allocated to only one of the followers.
        Input
        The first line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. The first
        line of each case contains two integers N and K, with N denoting the number of sanskars and K denoting the number of followers.
        In the next line are N space separated integers denoting the intensities of each sanskar.
        Output
        For each test case, output "yes" if it is possible to divide his sanskars equally amongst his followers; otherwise output
        "no" (without quotes).
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
