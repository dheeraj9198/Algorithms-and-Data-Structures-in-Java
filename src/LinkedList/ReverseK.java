package LinkedList;

/**
 * Created by dheeraj on 7/7/2016.
 */
public class ReverseK {

    private static Node insert(int k, Node node) {
        if (node == null) {
            return new Node(k);
        } else {
            Node node1 = new Node(k);
            node1.next = node;
            return node1;
        }
    }

    private static class Data {
        Node start, end;
        boolean ended;

        public Data(Node start, Node end, boolean ended) {
            this.start = start;
            this.end = end;
            this.ended = ended;
        }
    }

    private static Data revk(Node root, int k) {
        if(root == null){
            return new Data(null,null,true);
        }
        int x = 0;
        Node prev = null;
        Node current = root;
        Node next;
        while (current != null && x < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            x++;
        }
        root.next = current;
        return new Data(prev, root, x < k);
    }

    public static void main(String[] strings) {
        Node node = new Node(10);
        for (int k = 9; k >= 1; k--) {
            node = insert(k, node);
        }

        Node root = null;
        Node start = node;
        while (true) {
            Data data = revk(root == null ? start : start.next, 5);
            if (root == null) {
                root = data.start;
            } else {
                start.next = data.start;
            }
            start = data.end;
            if (data.ended) {
                break;
            }

        }
        System.out.println();
    }


}
