package sorting;

/**
 * Created by dheeraj on 7/9/2016.
 */
public class NutsAndBolts {

    private static int getPartition(char[] array, int start, int end, char pivotValue) {
        //end pivot
        int index = start;
        for (int x = start; x <= end - 1; x++) {
            if (array[x] < pivotValue) {
                char xxx = array[x];
                array[x] = array[index];
                array[index] = xxx;
                index++;
            } else if (array[x] == pivotValue) {
                //to maintain end pivot
                char xxx = array[end];
                array[end] = pivotValue;
                array[x] = xxx;
            }
        }
        char xxx = array[index];
        array[index] = array[end];
        array[end] = xxx;
        return index;
    }

    public static void main(String[] strings) {
        char[] nuts = new char[]{'a', 'b', 'd', 'c'};
        char[] bolts = new char[]{'b', 'a', 'd', 'c'};
        matchPairs(nuts, bolts, 0, nuts.length - 1);
        System.out.println(nuts);
        System.out.println(bolts);
    }

    private static void matchPairs(char[] nuts, char[] bolts, int low,
                                   int high) {
        if (low < high) {
            int l = getPartition(nuts, low, high, bolts[high]);
            getPartition(bolts, low, high, nuts[l]);
            matchPairs(nuts,bolts,low,l-1);
            matchPairs(nuts,bolts,l+1,high);
        }
    }


}
