package BinaryTree;

/**
 * Created by dheeraj on 24/2/15.
 */
class Node {
    Node left;
    Node right;
    int data;

    Node(int d) {
        data = d;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
