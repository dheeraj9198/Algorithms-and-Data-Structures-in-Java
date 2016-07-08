package heap;

/**
 * Created by dheeraj on 7/5/2016.
 */
public class KthMinElemUsingMaxHeap {

    static int[] heap;
    static int size = 0;

    private static boolean built = false;

    private static void insert(int a) {
        if (size < heap.length ) {
            heap[size] = a;
            size = size + 1;
        }
        if (size == heap.length ) {
            if (!built) {
                buildHeap();
                built = true;
            } else {
                replace(a);
            }
        }
    }

    private static void replace(int a) {
        if (heap[0] > a) {
            heap[0] = a;
            heapify(0);
        }
    }

    private static void buildHeap() {
        int k = getParent(size);
        for (int j = k; j >= 0; j--) {
            heapify(j);
        }
    }

    private static void heapify(int j) {
        int left = getLeftChild(j);
        int right = getRightChild(j);
        int max = j;
        if (left < heap.length) {
            if (heap[left] > heap[max]) {
                max = left;
            }
        }
        if (right < heap.length) {
            if (heap[right] > heap[max]) {
                max = right;
            }
        }
        if (max != j) {
            int l = heap[max];
            heap[max] = heap[j];
            heap[j] = l;
            heapify(max);
        }
    }

    private static int getParent(int index) {
        return (index - 1) / 2;
    }

    private static int getLeftChild(int index) {
        return 2 * index + 1;
    }

    private static int getRightChild(int index) {
        return 2 * index + 2;
    }

    public static void main(String[] strings) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        heap = new int[2];
        for (int k = 0; k < arr.length; k++) {
            insert(arr[k]);
        }
        System.out.println(heap[0]);
    }
}
