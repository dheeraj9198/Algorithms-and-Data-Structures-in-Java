package BinaryTree;

/**
 * Created by dheeraj on 6/30/2016.
 */
public class MaxSumSubTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int max = 0;

    private static int maxSum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = maxSum(root.left);
        int rightMaxSum = maxSum(root.right);

        int allSum = leftMaxSum + rightMaxSum + root.data;
        int data = root.data;


        max = Math.max(max, allSum);
        return allSum;

    }

    public static void main(String[] strings) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-125);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        maxSum(root);
        System.out.println(max);
    }
}
