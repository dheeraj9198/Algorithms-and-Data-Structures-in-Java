/**
 * Created by dheeraj on 12/12/14.
 */
public class ReverseALinkedList {

    public static class Node {
        int value;
        Node next;

        public Node(int data) {
            value = data;
            next = null;
        }
    }

    public static class LinkedList {
        Node root;
        int length;

        public LinkedList() {
            root = null;
            length = 0;
        }

        public void insert(int data) {
            root = insertPrivate(root, data);
            length++;
        }

        private Node insertPrivate(Node root, int data) {
            if (root == null) {
                root = new Node(data);
            } else {
                root.next = insertPrivate(root.next, data);
            }
            return root;
        }

        public void traverse() {
            traversePrivate(root);
        }

        private void traversePrivate(Node root) {
            if (root == null) {
                return;
            } else {
                System.out.println(root.value);
                traversePrivate(root.next);
            }
        }

        public void reverse() {
            root = reversePrivate(root);
        }

        private Node reversePrivate(Node root) {
            Node previous = null;
            Node current = root;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            return previous;
        }

        public void reverseFromNthNodeFromStart(int n) {
            Node temp = root;
            for (int x = 1; x <= n-1; x++) {
                temp = root.next;
                if (temp == null) {
                    return;
                }
            }
            temp.next = reversePrivate(temp.next);
        }

        public void reverseFromNthNodeFromEnd(int n){
            reverseFromNthNodeFromStart(length-n);
        }

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);


        //linkedList.reverseFromNthNodeFromStart(2);
        linkedList.reverseFromNthNodeFromEnd(5);

        linkedList.traverse();

    }


}
