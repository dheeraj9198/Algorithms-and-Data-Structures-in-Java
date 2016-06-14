package reloaded2016;

/**
 * Created by dheeraj on 9/6/16.
 */
public class Queue {
    private static class Node {
        int data;
        Node node;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node first, last;

    public void enqueue(int data) {
        if (first == null) {
            first = new Node(data);
            last = first;
        } else {
            last.node = new Node(data);
            last = last.node;
        }
    }

    public int dequeue() {
        if (first == null) {
            throw new RuntimeException("queue is empty");
        } else {
            int data = first.data;
            first = first.node;
            return data;
        }
    }

    public static void main(String[] strings)
    {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        while(true) {
            try {
                System.out.println(queue.dequeue());
            }catch (Exception e){
                break;
            }
        }
    }


}
