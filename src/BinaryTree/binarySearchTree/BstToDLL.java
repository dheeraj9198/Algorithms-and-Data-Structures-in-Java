package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 28/3/15.
 */
public class BstToDLL {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }
    }

    private static Node rootFinal = null;
    private static Node prev = null;

    private static void makeDll(Node root) {
        if (root == null) {
            return;
        }
        makeDll(root.left);
        if (rootFinal == null) {
            rootFinal = root;
        } else {
            root.left = prev;
            if(prev != null) {
                prev.right = root;
            }
        }
        prev = root;
        makeDll(root.right);
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private static void dllTraverse(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inorder(root);
        System.out.println();
        makeDll(root);
        dllTraverse(rootFinal);
    }


}
