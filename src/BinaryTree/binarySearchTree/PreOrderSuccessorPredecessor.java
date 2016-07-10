package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 7/10/2016.
 */
public class PreOrderSuccessorPredecessor {

    private static Node node = null;

    private static void preOrderPrede(Node root, int value) {
        if (root == null) {
            return;
        }
        if (root.data < value) {
            if (node == null) {
                node = root;
            } else if(node.data < root.data) {
                node = root;
            }
            preOrderPrede(root.right, value);
        } else {
            preOrderPrede(root.left, value);
        }
    }

    public static void main(String[] strings) {
           /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        preOrderPrede(root,65);
        System.out.println(node.data);

    }

}
