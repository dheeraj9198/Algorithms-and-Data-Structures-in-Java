package Array;

/**
 * Created by dheeraj on 7/17/2016.
 * 1 2 3 5 7 9
 * ans 3
 * <p>
 * 1- sort and do O(NlogN)
 * 2- counting sort O(MaxElemValue)
 * 3- quick select O(N)
 */
public class ExactlyXelemGreaterThanX {

    //num exists in array
/*    private static int getXContains(int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        int part = partition(ints, start, end);
        while (part != -1 && ints[part] != ints.length-1 - part ) {
            if (ints[part] > ints.length-1 - part) {
                end = part - 1;
                part = partition(ints, start, end);
            } else {
                start = part + 1;
                part = partition(ints, start, end);
            }
        }
        return part == -1 ? -1 : ints[part];
    }*/

    //array does not contain that number
    private static int getXNotContains(int[] ints) {
        int start = 0;
        int end = ints.length - 1;
        int part = partition(ints, start, end);
        while (part != -1 && part + 1 != ints.length - 1 - part) {
            if (ints[part] > ints.length - 1 - part) {
                end = part - 1;
                part = partition(ints, start, end);
            } else {
                start = part + 1;
                part = partition(ints, start, end);
            }
        }
        return part == -1 ? -1 : part + 1;
    }

    private static int partition(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }
        int pivot = array[end];
        int index = start;

        int temp;
        for (int a = start; a < end; a++) {
            if (array[a] < pivot) {
                temp = array[index];
                array[index] = array[a];
                array[a] = temp;
                index++;
            }
        }
        temp = array[index];
        array[index] = pivot;
        array[end] = temp;
        return index;
    }

    public static void main(String[] strings) {
/*
        int[] ints = new int[]{3, 1, 2, 7, 9, 5};
*/
        int[] ints = new int[]{0, 1, 2, 7, 9, 5};
        System.out.println(getXNotContains(ints));
    }

}
