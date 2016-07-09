package BinaryTree;

/**
 * Created by dheeraj on 23/3/15.
 * find lowest common ancestor of two nodes in the given tree
 */
public class LowestCommonAncestor {
    private Node root;

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int d) {
            this.data = d;
        }
    }

    private LowestCommonAncestor(Node r) {
        this.root = r;
    }


    private int find(int one, int two) {
        return findLca(root, one, two).data;
    }

    private Node findLca(Node root, int left, int right) {
        if (root == null) {
            return root;
        }

        if (root.data == left || root.data == right) {
            return root;
        }

        Node leftNode = findLca(root.left, left, right);
        Node rightNode = findLca(root.right, left, right);

        if (leftNode != null && rightNode != null) {
            return root;
        } else {
            return rightNode != null ? rightNode : leftNode;
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

        root.left.left.left = new Node(8);
        root.right.right.right = new Node(15);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor(root);
        System.out.println(lowestCommonAncestor.find(8, 5));
    }


}
