package LinkedList;

/**
 * Created by dheeraj on 5/1/15.
 */
public class InsertionSortLinkedList {

    private static final class Node {
        int value;
        Node next;

        public Node(int d) {
            value = d;
            next = null;
        }
    }

    private Node root;
    private Node sortedHead;

    private void addData(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = root;
            root = temp;
        }
    }

    private void printList() {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void printSortedList() {
        Node temp = sortedHead;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void insertionSort() {
        Node outer = root;
        Node resultRoot = null;
        if (outer == null) {
            return;
        }
        while (outer != null) {
            if (resultRoot == null) {
                //System.out.println("null");
                resultRoot = new Node(outer.value);
            } else {
                Node t = resultRoot;
                if (outer.value < t.value) {
                    //current outer is smallest
                    //System.out.println("smallest");
                    Node temp = new Node(outer.value);
                    temp.next = t;
                    resultRoot = temp;
                } else {
                    boolean broken = false;
                    while (t.next != null) {
                        if (t.value < outer.value && outer.value <= t.next.value) {
                            Node temp = new Node(outer.value);
                            temp.next = t.next;
                            t.next = temp;
                            broken = true;
                            //System.out.println("middle");
                            break;
                        }
                        //
                        t = t.next;
                    }
                    if (!broken) {
                        //current outer is greatest
                        //System.out.println("largest");
                        t.next = new Node(outer.value);
                    }
                }
            }
            outer = outer.next;
        }
        sortedHead = resultRoot;
    }

    public static void main(String[] args) {
        InsertionSortLinkedList insertionSortLinkedList = new InsertionSortLinkedList();
        insertionSortLinkedList.addData(5);
        insertionSortLinkedList.addData(30);
        insertionSortLinkedList.addData(1);
        insertionSortLinkedList.addData(18);
        insertionSortLinkedList.addData(19);

        insertionSortLinkedList.printList();
        insertionSortLinkedList.insertionSort();
        insertionSortLinkedList.printSortedList();
    }
}
