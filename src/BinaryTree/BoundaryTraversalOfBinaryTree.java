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

    private static void printLeft(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            System.out.print(node.data + " ");
            printLeft(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printLeft(node.right);
        }
    }

    private static void printRight(Node node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            printLeft(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printLeft(node.left);
            System.out.print(node.data + " ");
        }
    }

    private static void printBottom(Node root) {
        if (root == null) {
            return;
        }
        printBottom(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printBottom(root.right);
    }

    public static void main(String[] strings) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        //20 8 4 10 14 25 22
        printLeft(root);
        printBottom(root);
        printRight(root.right);

    }

}
