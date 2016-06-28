package BinaryTree;

/**
 * Created by dheeraj on 28/6/16.
 */
public class LCAinBT {

    private static boolean oneF, twof;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static Node findLcs(Node root, int one, int two) {
        if (root == null) {
            return null;
        }
        if (root.data == one) {
            oneF = true;
            return root;
        }

        if (root.data == two) {
            twof = true;
            return root;
        }

        Node left = findLcs(root.left, one, two);
        Node right = findLcs(root.right, one, two);

        if (left != null && right != null)

        {
            return root;
        }

        return left == null ? right : left;


    }

    public static void main(String[] strings) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(8);
        node.left.right = new Node(9);
        Node data = findLcs(node, 8, 9);
        if(data != null && oneF && twof) {
            System.out.println(data.data);
        }else{
             System.out.println("nf");
        }

    }

}
