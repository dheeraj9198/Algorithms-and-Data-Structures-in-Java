package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 6/21/2016.
 */
public class BSTDelete {

    public static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    private Node insert(int data, Node root) {
        if (root == null) {
            return new Node(data);
        } else if (data > root.data) {
            root.right = insert(data, root.right);
        } else if (data < root.data) {
            root.left = insert(data, root.left);
        }
        return root;
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private Node delete(int data, Node root) {
        if (root == null) {
            return null;
        } else if (data > root.data) {
            root.right = delete(data, root.right);
        } else if (data < root.data) {
            root.left = delete(data, root.left);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                Node inOrderSuccessor = findInOrderSuccessor(root.right);
                root.data = inOrderSuccessor.data;
                return delete(inOrderSuccessor.data, inOrderSuccessor);
            }
        }
        return root;
    }

    private Node findInOrderSuccessor(Node right) {
        if (right.left == null) {
            return right;
        } else {
            return findInOrderSuccessor(right.left);
        }
    }

    public static void main(String[] args) {
        BSTDelete tree = new BSTDelete();
        tree.root = tree.insert(50, tree.root);
        tree.root = tree.insert(30, tree.root);
        tree.root = tree.insert(20, tree.root);
        tree.root = tree.insert(40, tree.root);
        tree.root = tree.insert(70, tree.root);
        tree.root = tree.insert(60, tree.root);
        tree.root = tree.insert(80, tree.root);
        tree.root = tree.insert(90, tree.root);

        tree.inOrderTraversal(tree.root);
        System.out.println();
        tree.delete(70,tree.root);
        tree.inOrderTraversal(tree.root);
    }

}
