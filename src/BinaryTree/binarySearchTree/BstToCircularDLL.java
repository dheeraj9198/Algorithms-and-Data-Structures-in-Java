package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 28/3/15.
 */
public class BstToCircularDLL {
    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }
    }

    private static Node leftMost = null;
    private static Node rightMost = null;

    private static Node makeDll(Node node, int position) {
        // 1 left 2 right 0 none
        if (node == null) {
            return node;
        }

        Node left = makeDll(node.left, 1);
        Node right = makeDll(node.right, 2);

        node.left = null;
        node.right = null;

        if (left != null) {
            left.right = node;
            node.left = left;
        }

        if (right != null) {
            right.left = node;
            node.right = right;
        }

        if (position == 1) {
            if (leftMost == null) {
                leftMost = left == null ? node : left;
            }
            return right == null ? node : right;
        } else if (position == 2) {
            rightMost = right == null ? node : right;
            return left == null ? node : left;
        }

        return leftMost;
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
        Node test = makeDll(root, 0);
        rightMost.right = leftMost;
        leftMost.left = rightMost.left;
        dllTraverse(test);
    }


}
