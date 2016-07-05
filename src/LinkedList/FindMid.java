package LinkedList;

/**
 * Created by dheeraj on 5/7/16.
 */
public class FindMid {

    //first will never become null
    //length is even or odd depeneds on second = null OR second.next = null at the time of return


    private static Node findMid(Node root) {
        if (root == null) {
            return null;
        }
        if(root.next == null){
            return root;
        }
        Node first = root;
        Node second = root;
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    public static void main(String[] strings) {
        Node node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(0);
        node.next.next.next.next = new Node(-1);

        Node node1 = findMid(node);
        System.out.print(node1);
    }

}
