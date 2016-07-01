package BinaryTree;

import java.util.Stack;

/**
 * Created by dheeraj on 7/1/2016.
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 */
public class SpiralTraversal {

    public static void main(String[] strings) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);


        Stack<Node> stackOne = new Stack<Node>();
        Stack<Node> stackTwo = new Stack<Node>();

        stackOne.add(root);

        while (!stackOne.empty() || !stackTwo.empty()) {

            while (!stackOne.empty()){
                Node node = stackOne.pop();
                System.out.print(node.data+" ");
                if(node.right != null)
                stackTwo.add(node.right);
                if(node.left != null)
                stackTwo.add(node.left);
            }

            while (!stackTwo.empty()){
                Node node = stackTwo.pop();
                System.out.print(node.data+" ");
                if(node.left != null)
                stackOne.add(node.left);
                if(node.right != null)
                stackOne.add(node.right);
            }

        }
    }

}
