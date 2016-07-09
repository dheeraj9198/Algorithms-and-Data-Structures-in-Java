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

    private static int dl = -1;
    private static int dr = -1;
    private static int droot = -1;

    private int findLca(Node root, int left, int right, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.data == left || root.data == right) {
            if (root.data == left) {
                return distance;
            } else {
                return distance;
            }
        }

        int l = findLca(root.left, left, right, distance + 1);
        int r = findLca(root.right, left, right, distance + 1);

        if (l > -1 && r > -1 && droot == -1) {
            dl = l;
            dr = r;
            droot = distance;
        }
        return l > r ? l : r;
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
        lowestCommonAncestor.find(7, 8);
        System.out.println((dl + dr - 2 * droot));
    }


}
