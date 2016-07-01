package BinaryTree;

/**
 * Created by dheeraj on 23/3/15.
 * find lowest common ancestor of two nodes in the given tree
 */
public class LowestCommonAncestorDistance {
    private Node root;

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int d) {
            this.data = d;
        }
    }

    private LowestCommonAncestorDistance(Node r) {
        this.root = r;
    }


    private void find(int one, int two) {
        findLca(root, one, two, 0);
    }

    private static int dl = 0;
    private static int dr = 0;
    private static int droot = 0;

    private void findLca(Node root, int left, int right, int distance) {
        if (root == null) {
            return;
        }

        if (root.data == left || root.data == right) {
            if (root.data == left) {
                dl = distance;
            } else {
                dr = distance;
            }
        }

        findLca(root.left, left, right, distance + 1);
        findLca(root.right, left, right, distance + 1);

        if (dl > 0 && dr > 0) {
            droot = distance;
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

        LowestCommonAncestorDistance lowestCommonAncestor = new LowestCommonAncestorDistance(root);
        lowestCommonAncestor.find(15, 8);
        System.out.println((dl + dr - 2 * droot));
    }


}
