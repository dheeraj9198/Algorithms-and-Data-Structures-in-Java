package BinaryTree;

import java.util.Stack;

/**
 * Created by dheeraj on 24/2/15.
 */
public class RootToLeafPaths {
    private Node root;

    private void findPath(Node root, Stack<Integer> integerStack) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            integerStack.push(root.data);
            System.out.println(integerStack);
            integerStack.pop();
            return;
        }
        if (root.left != null) {
            integerStack.push(root.data);
            findPath(root.left, integerStack);
            integerStack.pop();
        }

        if (root.right != null) {
            integerStack.push(root.data);
            findPath(root.right, integerStack);
            integerStack.pop();
        }

    }

    public static void main(String[] args) {
        RootToLeafPaths rootToLeafPaths = new RootToLeafPaths();
        rootToLeafPaths.root = new Node(1);

        rootToLeafPaths.root.left = new Node(2);
        rootToLeafPaths.root.right = new Node(3);

        rootToLeafPaths.root.left.left = new Node(4);
        rootToLeafPaths.root.left.right = new Node(5);
        rootToLeafPaths.root.right.left = new Node(6);
        rootToLeafPaths.root.right.right = new Node(7);
        rootToLeafPaths.root.right.right.right = new Node(8);
        rootToLeafPaths.findPath(rootToLeafPaths.root, new Stack<Integer>());

    }
}
