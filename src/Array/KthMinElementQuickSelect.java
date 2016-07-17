package Array;

/**
 * Created by dheeraj on 7/17/2016.
 */
public class KthMinElementQuickSelect {

    private static int getKthMin(int k, int[] ints) {
        int part = partition(ints, 0, ints.length - 1);
        while (part != k - 1) {
            if (part > k - 1) {
                part = partition(ints, 0, part - 1);
            } else {
                part = partition(ints, part + 1, ints.length - 1);
            }
        }
        return part == -1 ? -1 : ints[part];
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
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println(getKthMin(2, arr));
    }
}
