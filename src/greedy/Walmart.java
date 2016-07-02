package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/14/14
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Walmart {

    public static class Data {
        int startTime;
        int endTime;
        int duration;

        public Data(int start, int end) {
            this.startTime = start;
            this.endTime = end;
            this.duration = endTime - startTime;
        }
    }

    public static void main(String[] args) throws Exception {
       /* String input = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        input = bufferedReader.readLine();
        String[] inputs = input.substring(1,input.length()-1).split(",");
        Data[] inputData = new Data[inputs.length];

        for(int x =0;x<inputs.length;x++){
            String[] temp = inputs[x].split("#");
            int start;
            int end;
            if(temp[0].endsWith("AM")){
                start = Integer.parseInt(temp[0].substring(0,temp[0].length()-2));
            }else{
                start =12+ Integer.parseInt(temp[0].substring(0,temp[0].length()-2));
            }

            if(temp[1].endsWith("AM")){
                end = Integer.parseInt(temp[1].substring(0, temp[1].length() - 2));
            }else{
                end =12+ Integer.parseInt(temp[1].substring(0, temp[1].length() - 2));
            }
            inputData[x] = new Data(start,end);
        }*/
        int length = args.length;
        Data[] inputData = new Data[length];

        for (int x = 0; x < length; x++) {
            String[] temp = args[x].split("#");
            int start;
            int end;
            if (temp[0].endsWith("AM")) {
                start = Integer.parseInt(temp[0].substring(0, temp[0].length() - 2));
            } else {
                start = 12 + Integer.parseInt(temp[0].substring(0, temp[0].length() - 2));
            }

            if (temp[1].endsWith("AM")) {
                end = Integer.parseInt(temp[1].substring(0, temp[1].length() - 2));
            } else {
                end = 12 + Integer.parseInt(temp[1].substring(0, temp[1].length() - 2));
            }
            inputData[x] = new Data(start, end);
        }

       /* Arrays.sort(inputData, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.endTime == o2.endTime) {
                    return o1.duration - o2.duration;
                } else {
                    return o1.endTime - o2.endTime;
                }
            }
        });*/

        MergeSort mergeSort = new MergeSort(inputData);
        mergeSort.mergeSort();

        int endTime = -1;
        int moneyEarned = 0;

        for (int x = 0; x < inputData.length; x++) {
            if (endTime == -1) {
                endTime = inputData[x].endTime;
                moneyEarned += 500;
            } else {
                if (endTime <= inputData[x].startTime) {
                    endTime = inputData[x].endTime;
                    moneyEarned += 500;
                }
            }
        }

        System.out.println(moneyEarned);
    }

    public static class MergeSort {

        Data[] array;
        Data[] tempArray;
        int length;

        public MergeSort(Data[] arr) {
            this.array = arr;
            this.length = arr.length;
            this.tempArray = new Data[length];
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
                    if (tempArray[m].endTime < tempArray[n].endTime) {
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
