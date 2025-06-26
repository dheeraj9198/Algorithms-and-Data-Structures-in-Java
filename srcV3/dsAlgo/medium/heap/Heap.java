package dsAlgo.medium.heap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A heap is a binary tree-based data structure that maintains a special property called the heap property:
 * In a Min-Heap, the parent is less than or equal to its children.
 * In a Max-Heap, the parent is greater than or equal to its children.
 * <p>
 * A heap is typically implemented as a binary heap, which is a complete binary tree (all levels filled except possibly the last, filled left to right).
 * <p>
 * For node at index i: [0 based indexing]
 * <p>
 * Left child: 2i + 1
 * <p>
 * Right child: 2i + 2
 * <p>
 * Parent: (i - 1) / 2 (integer division)
 */
public class Heap {

    /**
     * Heapify Process (Min-Heap)
     * <p>
     * Identify the last non-leaf node in the array.
     * Since leaves are already heaps, you start with the last node that has children.
     * This node is at index floor(n/2) - 1 where n is the number of elements.
     * <p>
     * Move from this last non-leaf node backward to the root node (index 0).
     * You will “fix” the heap property starting from these nodes up to the root.
     * <p>
     * For each node you visit:
     * Compare the node with its left and right children.
     * Find the smallest among the node and its children.
     * <p>
     * If the node is not the smallest, swap it with the smallest child.
     * <p>
     * After swapping, repeat the same comparison and swapping process recursively for the child node you just swapped with (since the heap property might now be violated there).
     * <p>
     * Continue this process until every node from the last non-leaf node up to the root satisfies the min-heap property — meaning each node is smaller than its children.
     * <p>
     * Complexity : O(n)
     */
    private static void heapifyArray(ArrayList<Integer> arr) {
        int lastNonLeaf = (arr.size() - 1 - 1) / 2;//  arr.length - 1 is the last index, using (i-1)/2
        for (int x = lastNonLeaf; x >= 0; x--) {
            siftDown(arr, x, arr.size());
        }
    }

    private static void siftDown(ArrayList<Integer> arr, int index, int length) {
        int minIndex = index;
        //check left child if present and smaller
        int leftChild = 2 * index + 1;
        if (leftChild < length && arr.get(leftChild) < arr.get(minIndex)) {
            minIndex = leftChild;
        }
        //check right child if present and smaller
        int rightChild = 2 * index + 2;
        if (rightChild < length && arr.get(rightChild) < arr.get(minIndex)) {
            minIndex = rightChild;
        }
        if (minIndex != index) {
            int data = arr.get(minIndex);
            arr.set(minIndex, arr.get(index));
            arr.set(index, data);
            siftDown(arr, minIndex, length);
        }
    }

    private static void siftUp(ArrayList<Integer> arr, int index, int size) {
        if (index == 0) {
            return;
        }
        int parentIndex = (index - 1) / 2;
        if (arr.get(parentIndex) > arr.get(index)) {
            int data = arr.get(parentIndex);
            arr.set(parentIndex, arr.get(index));
            arr.set(index, data);
            siftUp(arr, parentIndex, size);
        }
    }

    public static void main(String[] strings) {
        int[] ints = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> list = (ArrayList<Integer>) IntStream.of(ints)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(ints));
        //test heapify
        heapifyArray(list);
        System.out.println(list);
        insert(0, list);
        System.out.println(list);
        System.out.println(extractMin(list));
        System.out.println(list);
        heapSort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    /**
     * Add element to the last and siftUp to maintain heap property
     * O(log n)
     */
    private static void insert(int x, ArrayList<Integer> list) {
        list.add(x);
        siftUp(list, list.size() - 1, list.size());
    }

    /**
     * extractMin() Remove first element
     * fill in last element at 0 index and siftDown to maintain heap property
     * return the removed first element
     * O(log n)
     * <p>
     * peek() Get the root without removing it O(1)
     */
    private static int extractMin(ArrayList<Integer> list) {
        int min = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size()-1);
        siftDown(list, 0, list.size());
        return min;
    }

    /**
     * create min heap, index 0 has min element
     * swap index 0 with last and siftDown to maintain heap property for 0 index till second last element
     * heap sort O(n log n)
     */
    private static void heapSort(ArrayList<Integer> list) {
        heapifyArray(list);
        for (int x = list.size() - 1; x >= 0; x--) {
            int data = list.get(0);
            list.set(0, list.get(x));
            list.set(x, data);
            siftDown(list, 0, x);
        }
    }


}
