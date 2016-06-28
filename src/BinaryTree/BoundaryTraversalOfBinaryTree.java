package BinaryTree;

/**
 * Created by dheeraj on 6/28/2016.
 */
public class BoundaryTraversalOfBinaryTree {

    static class Node {
        Node left, right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void printBoundary(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null || node.right == null) {
            System.out.print(node.data + " ");
        }

        printBoundary(node.left);
        printBoundary(node.right);

    }

    public static void main(String[] strings){
        Node root         = new Node(20);
        root.left                = new Node(8);
        root.left.left          = new Node(4);
        root.left.right         = new Node(12);
        root.left.right.left   = new Node(10);
        root.left.right.right  = new Node(14);
        root.right               = new Node(22);
        root.right.right        = new Node(25);

        System.out.print(root.data+" ");
        printBoundary(root);

    }

}
