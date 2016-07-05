package LinkedList;

/**
 * Created by dheeraj on 5/7/16.
 */
public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }
}