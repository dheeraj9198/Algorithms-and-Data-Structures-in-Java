package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class BstFloor {

    static Node prevFloor = null;

    private static Node floor(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        } else if (node.data < data) {
            prevFloor = node;
            Node floor = floor(node.right, data);
            if (floor != null) {
                prevFloor = floor;
            }
        } else {
            Node floor = floor(node.left, data);
            if (floor != null) {
                prevFloor = floor;
            }
        }
        return prevFloor;
    }

    public static void main(String[] s) {
        int[] ints = new int[]{1, 2, 8, 10, 10, 12, 19};
        Node node = SortedArrayToBst.makeTree(ints, 0, ints.length - 1);
        System.out.print(floor(node, 10));
    }
}
