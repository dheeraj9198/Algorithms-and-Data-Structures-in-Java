import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by dheeraj on 19/1/15.
 */
public class PrintLeftViewOfTree {

    private int height = -1;
    private Node root;

    private static class Node{
        Node left;
        Node right;
        int value;
        int distance;
        private Node(int data){
            this.left = null;
            this.right = null;
            this.value = data;
            this.distance = -1;
        }
    }

    private void printLeft(){
        root.distance = 0;

        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(root);

        Node temp;

        while(!nodeQueue.isEmpty()){
            temp = nodeQueue.remove();
            if(temp.distance > height){
                System.out.println(temp.value);
                height = temp.distance;
            }

            if(temp.left != null){
                temp.left.distance = temp.distance+1;
                nodeQueue.add(temp.left);

            }

            if(temp.right != null){
                temp.right.distance = temp.distance+1;
                nodeQueue.add(temp.right);
            }

        }
    }

public static void main(String[] args){
    PrintLeftViewOfTree printLeftViewOfTree = new PrintLeftViewOfTree();
    printLeftViewOfTree.root = new Node(1);
    printLeftViewOfTree.root.left = new Node(2);
    printLeftViewOfTree.root.right = new Node(3);
    printLeftViewOfTree.root.left.left = new Node(4);
    printLeftViewOfTree.root.left.right = new Node(5);
    printLeftViewOfTree.root.right.left = new Node(6);
    printLeftViewOfTree.root.right.right = new Node(7);
    printLeftViewOfTree.root.right.right.right = new Node(8);

    printLeftViewOfTree.printLeft();
}


}
