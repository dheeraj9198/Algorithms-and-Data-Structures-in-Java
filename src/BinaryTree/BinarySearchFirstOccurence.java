package BinaryTree;

/**
 * Created by dheeraj on 19/1/15.
 */
public class BinarySearchFirstOccurence {

    private int[] array;
    int value;

    private BinarySearchFirstOccurence(int[] arr, int val) {
        array = arr;
        value = val;
    }

    private int search(int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid - 1] < value && value <= array[mid]) {
            return mid;
        }

        if (array[mid] < value) {
            return search(mid + 1, end);
        } else {
            return search(start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3, 3, 4, 5, 6, 7, 7, 7,};
        BinarySearchFirstOccurence binarySearchFirstOccurence = new BinarySearchFirstOccurence(test,3);
        System.out.print(binarySearchFirstOccurence.search(0, test.length - 1));
    }

}
