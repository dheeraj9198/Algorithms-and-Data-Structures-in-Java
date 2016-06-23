package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 29/3/15.
 */
public class SortedDLLtoBST {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }
    }

    private static void dllTraverse(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    private static Node makeBst(Node root) {
        if (root == null) {
            return root;
        }

        if(root.left == null && root.right == null){
            return root;
        }
        Node rootNew = findMid(root);

        if (rootNew.left != null) {
            rootNew.left.right = null;
        }
        if (rootNew.right != null) {
            rootNew.right.left = null;
        }
        Node right = rootNew.right;
        rootNew.right = null;
        rootNew.left = null;

        rootNew.left = makeBst(root);
        rootNew.right = makeBst(right);
        return rootNew;
    }

    private static Node findMid(Node root) {
        if (root == null) {
            return root;
        }
        Node one = root;
        Node two = root;
        while (two.right != null && two.right.right != null) {
            one = one.right;
            two = two.right.right;
        }
        return one;
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node last = root;
        for (int k = 2; k <= 7; k++) {
            Node temp = new Node(k);
            last.right = temp;
            temp.left = last;
            last = temp;
        }

        dllTraverse(root);
        System.out.println();
        Node node = makeBst(root);
        inorder(node);

    }
}
