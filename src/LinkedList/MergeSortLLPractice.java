package LinkedList;

/**
 * Created by dheeraj on 5/7/16.
 */
public class MergeSortLLPractice {

    private static Node sort(Node node, int size) {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return node;
        }

        int mid = size / 2;
        Node temp = node;
        for (int k = 1; k < mid; k++) {
            temp = temp.next;
        }

        Node sec = temp.next;
        temp.next = null;

        Node nodeLeft = sort(node, mid);
        Node nodeRight = sort(sec, size - mid);

        Node start = null, startTemp = null;

        while (nodeLeft != null && nodeRight != null) {
            if (nodeLeft.data < nodeRight.data) {
                if (start == null) {
                    start = nodeLeft;
                    startTemp = start;
                } else {
                    startTemp.next = nodeLeft;
                    startTemp = startTemp.next;
                }
                nodeLeft = nodeLeft.next;
            } else {
                if (start == null) {
                    start = nodeRight;
                    startTemp = start;
                } else {
                    startTemp.next = nodeRight;
                    startTemp = startTemp.next;
                }
                nodeRight = nodeRight.next;
            }
        }
        if (nodeLeft != null) {
            startTemp.next = nodeLeft;
        }
        if (nodeRight != null) {
            startTemp.next = nodeRight;
        }

        return start;
    }

    public static void main(String[] strings) {
        Node node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(1);

        Node node1 = sort(node,1);
        System.out.print(node1);
    }


}
