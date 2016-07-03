package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class UnionTwoBsts {

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    static void traverse(Node node) {
        if (node == null) {
            return;
        }
        insert(root2, node.data);
        traverse(node.left);
        traverse(node.right);
    }

    static Node root2;


    public static void main(String[] strings) {
        Node node1 = new Node(2);
        node1.left = new Node(1);
        node1.right = new Node(5);

        Node node2 = new Node(4);
        node2.left = new Node(3);
        node2.right = new Node(6);

        root2 = node2;
        traverse(node1);
        System.out.println();

    }

}
