package reloaded2016;

/**
 * Created by dheeraj on 9/6/16.
 */
public class Stack {
    private static class Node {
        int data;
        Node node;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node first;

    public void add(int data) {
        if (first == null) {
            first = new Node(data);
        } else {
            Node node = new Node(data);
            node.node = first;
            first = node;
        }
    }

    public int remove() {
        if (first == null) {
            throw new RuntimeException("queue is empty");
        } else {
            int data = first.data;
            first = first.node;
            return data;
        }
    }

    public static void main(String[] strings) {
        Stack queue = new Stack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (true) {
            try {
                System.out.println(queue.remove());
            } catch (Exception e) {
                break;
            }
        }
    }
}
