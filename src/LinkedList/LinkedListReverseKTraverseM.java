package LinkedList;

/**
 * Created by dheeraj on 6/29/2016.
 * Given a linked-list and 2 integers k & m. Reverse the linked-list till k elements and then traverse till m elements and repeat.
 */
public class LinkedListReverseKTraverseM {

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Data {
        Node newRoot, afterK;
        boolean ended;

        public Data(Node newRoot, Node afterK, boolean ended) {
            this.newRoot = newRoot;
            this.afterK = afterK;
            this.ended = ended;
        }
    }

    private static Data reverseK(Node root, int k) {
        int x = 1;
        Node prev = null;
        Node current = root;
        Node next;

        Node start = root;
        while (current != null && x <= k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            x++;
        }

        if (x == k) {
            current.next = start;
        }
        return new Data(prev, current, x < k);
    }

    private static Node insert(Node root, int data) {
        Node node = new Node(data);
        node.next = root;
        return node;

    }

    public static void main(String[] strings) {
        Node root = null;
        for (int x = 10; x > 0; x--) {
            root = insert(root, x);
        }
        Node revRoot = null;
        int rev = 3;
        int simple = 3;
        Node c = root;
        while (true) {
            Data data = reverseK(c, rev);
            if (revRoot == null) {
                revRoot = data.newRoot;
            } else {
                c.next = data.newRoot;
            }
            if (data.ended) {
                break;
            }
            int x = 1;
            c = data.afterK;
            while (x <= simple && c != null) {
                c = c.next;
                x++;
            }
            if (x < simple) {
                break;
            }
        }
        System.out.println("");
    }


}
