package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dheeraj on 7/7/2016.
 */
public class KDistanceAwayFromLeaf {

    static Set<Node> nodeList = new HashSet<Node>();

    private static List<Integer> run(Node node, int k) {
        if (node.left == null && node.right == null) {
            List<Integer> integers = new ArrayList<>();
            integers.add(0);
            return integers;
        }
        List<Integer> integers = new ArrayList<Integer>();

        if (node.left != null) {
            List<Integer> integersLeft = run(node.left, k);
            for (int dis : integersLeft) {
                integers.add(dis + 1);
                if (dis + 1 == k) {
                    nodeList.add(node);
                }
            }
        }
        if (node.right != null) {
            List<Integer> integersRight = run(node.right, k);
            for (int dis : integersRight) {
                integers.add(dis + 1);
                if (dis + 1 == k) {
                    nodeList.add(node);
                }
            }
        }
        return integers;
    }

    public static void main(String[] strings) {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left.left = new Node(8);
        node.left.left.left.left = new Node(8);
        node.left.left.right = new Node(10);

        run(node, 2);
        System.out.print(nodeList);

    }


}
