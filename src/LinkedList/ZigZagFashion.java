package LinkedList;

/**
 * Created by dheeraj on 7/5/2016.
 * Input:  1->2->3->4
 * Output: 1->3->2->4
 */
public class ZigZagFashion {

    private static void rearrange(Node node) {
        if (node == null || node.next == null || node.next.next == null) {
            return;
        }
        Node next = node.next;
        node.next = next.next;
        next.next = next.next.next;
        next.next = next;

        rearrange(next.next);
    }

    public static void main(String[] strings) {
        Node node = new Node(11);
        node.next = new Node(15);
        node.next.next = new Node(20);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(10);

        rearrange(node);
        System.out.print(node);
    }


}
