package ProblemSolving;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a tree where there are three pointers (left_pointer,
 * right_pointer and a next_right_pointer). Left and right pointers
 * are set like that of any general binary tree. We were asked to set
 * the next_right_pointer to the next node in the level order traversal
 * for the same level. This implies means for the last node in every
 * level it will be null for rest it will be pointer to the next node
 * in level order traversal.
 */
public class ThirdChildNextRight {

    public static class Node {
        Node left;
        Node right;
        Node magic;
        int data;
        int distance;

        public Node(int d) {
            left = null;
            right = null;
            magic = null;
            data = d;
            distance = -1;
        }
    }

    public static class BinaryTree {
        public Node root;

        public BinaryTree() {
            root = null;
        }

        public void insert(int data) {
            root = insert(root, data);
        }

        private Node insert(Node root, int data) {
            if (root == null) {
                root = new Node(data);
            } else if (data < root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
        }

        public void print() {
            print(root);
        }

        private void print(Node root) {
            if (root == null) {
                return;
            }
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }

        public void setMagicPointer() {
            Queue<Node> nodeQueue = new LinkedList<Node>();
            root.distance = 0;
            nodeQueue.add(root);

            while (!nodeQueue.isEmpty()) {
                Node temp = nodeQueue.remove();


                if (nodeQueue.peek() != null && nodeQueue.peek().distance == temp.distance) {
                    temp.magic = nodeQueue.peek();
                }

                if (temp != null && temp.left != null) {
                    temp.left.distance = temp.distance + 1;
                    nodeQueue.add(temp.left);

                }
                if (temp != null && temp.right != null) {
                    temp.right.distance = temp.distance + 1;
                    nodeQueue.add(temp.right);

                }
            }
        }

        public void printMagic() {
            printMagic(root);
        }

        private void printMagic(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data + "->" + (root.magic == null ? "none" : root.magic.data));
            printMagic(root.left);
            printMagic(root.right);
        }

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(20);
        binaryTree.insert(10);
        binaryTree.insert(30);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(25);
        binaryTree.insert(40);

        binaryTree.setMagicPointer();

        binaryTree.print();
        System.out.println("___________________________");
        binaryTree.printMagic();
    }

}
