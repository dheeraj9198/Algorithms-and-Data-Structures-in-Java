package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dheeraj on 7/2/2016.
 */
public class MaxLevelSum {


    private static void maxLevelSum(Node root) {
        int maxLevel = 0;
        int maxSum = 0;

        int level = 0;
        int sum = 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 0) {
            Node node = queue.poll();
            if (node == null) {
                //level ends
                if (sum > maxSum) {
                    maxSum = sum;
                    maxLevel = level;
                    level++;
                    sum = 0;
                }
                if (queue.size() > 0) {
                    //dont add null if elements have already ended
                    //eg 1 null -> dont add null in this case
                    //eg 1 null 2 3 -> add null in this case
                    queue.add(null);
                }
            } else {
                sum = sum+node.data;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

        }
        System.out.println("level = " + maxLevel + " sum = " + maxSum);

    }

    public static void main(String[] strings) {
      /*
                10
                /\
               2  10
              /\   \
            20 1   -25
                    /\
                   3 4
        */
        Node root = new Node(10);

        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);

        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        maxLevelSum(root);
    }
}
