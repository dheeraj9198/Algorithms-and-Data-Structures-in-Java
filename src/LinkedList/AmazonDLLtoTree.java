package LinkedList;

import java.util.*;

/**
 * Created by dheeraj on 7/15/2016.
 * double linked list 1->2->3>-4->5->6->7->8->9 create tree such that
 * <p>
 * 1
 * /\
 * 2  3
 * /\  /\
 * 4 5 6 7
 * /\
 * 8 9
 */
public class AmazonDLLtoTree {

    private static class Node {
        Node prev, next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        } else {
            Node node1 = new Node(data);
            node1.next = node;
            node.prev = node1;
            return node1;
        }
    }

    public static void main(String[] strings) {
        Node node = null;
        for (int k = 8; k >= 1; k--) {
            node = insert(node, k);
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Node nextNode = node.next;
        while (nextNode != null) {
            Node node1 = queue.poll();

            Node temp1 = nextNode;
            nextNode = nextNode.next;
            temp1.prev = null;
            temp1.next = null;
            node1.prev = temp1;

            queue.add(temp1);

            temp1 = nextNode;
            if(temp1 != null) {
                nextNode = nextNode.next;
                temp1.prev = null;
                temp1.next = null;
                node1.next = temp1;
                queue.add(temp1);
            }
        }
        System.out.println();
    }


}
