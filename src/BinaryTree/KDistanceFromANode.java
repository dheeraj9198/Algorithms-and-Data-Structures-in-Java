package BinaryTree;



import java.io.File;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.util.Map;
import java.util.jar.JarFile;

/**
 * Created by dheeraj on 7/10/2016.
 */
public class KDistanceFromANode {

    private static void printAtKFromCurrent(Node root, int currentDis, int diatance) {
        if (root == null) {
            return;
        }
        if (currentDis == diatance) {
            System.out.println(root.data);
            return;
        }
        printAtKFromCurrent(root.left, currentDis + 1, diatance);
        printAtKFromCurrent(root.right, currentDis + 1, diatance);
    }

    private static int findDis(Node node, int value, int distance) {
        if (node == null) {
            return -1;
        }
        if (node.data == value) {
            printAtKFromCurrent(node, 0, distance);
            return 1;
        }
        int left = findDis(node.left, value, distance);
        int right = findDis(node.right, value, distance);

        if (left > -1) {
            if (left == distance) {
                System.out.println(node.data);
            }
            printAtKFromCurrent(node.right, 1, distance - left);
            return left + 1;
        } else if (right > -1) {
            if (right == distance) {
                System.out.println(node.data);
            }
            printAtKFromCurrent(node.left, 1, distance - right);
            return right + 1;
        }
        return -1;
    }

    public static void main(String[] strings) {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left.left = new Node(8);
        node.left.left.left.left = new Node(9);
        node.left.left.right = new Node(10);
        findDis(node, 4, 2);
    }
}
