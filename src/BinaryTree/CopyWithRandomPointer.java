package BinaryTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class CopyWithRandomPointer {

    private static class Node {
        int data;
        Node left, right, random;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "*" + (random == null ? "null" : random.data);
        }
    }

    private static Node insertLeftNode(Node root) {

        if (root == null) {
            return null;
        }

        Node node = new Node(root.data);

        Node left = root.left;

        root.left = node;
        node.left = left;

        insertLeftNode(left);
        node.right = insertLeftNode(root.right);
        return node;

    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node + "  ");
        inorder(node.right);
    }

    private static void copyRandom(Node node, Node temp) {
        if (node == null) {
            return;
        }
        if (node.random != null){
            temp.random = node.random.left;
        }
        if(node.left != null && temp.left != null) {
            copyRandom(node.left.left, temp.left.left);
        }
        copyRandom(node.right, temp.right);
    }

    private static void restoreTree(Node node, Node clone) {
        if (node == null) {
            return;
        }
        if (clone.left != null) {
            node.left = clone.left;
            clone.left = clone.left.left;
        }
        restoreTree(node.left, clone.left);
        restoreTree(node.right, clone.right);
    }

    public static void main(String[] strings) {
        Node node = new Node(2);
        Node node1 = new Node(1);
        Node node2 = new Node(3);

        node.left = node1;
        node.right = node2;

        node1.random = node2;
        inorder(node);

        Node temp = insertLeftNode(node);
        copyRandom(node,temp);
        System.out.println();
        inorder(node);

        restoreTree(node, temp);

        inorder(temp);
    }

}
