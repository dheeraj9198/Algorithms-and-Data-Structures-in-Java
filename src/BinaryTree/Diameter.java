package BinaryTree;

/**
 * Created by dheeraj on 23/2/15.
 */
public class Diameter {
    private int maxDia = 0;
    private static class Node {
        Node left;
        Node right;
        int data;

        private Node(int d){
            data = d;
        }
    }

    private Node root;

    private int findDia(Node root) {
        if (root == null) {
            return 0;
        }

        int left = findDia(root.left);
        int right = findDia(root.right);

        maxDia = Math.max(maxDia,left+right+1);
        return Math.max(left,right)+1;
    }


    public static void main(String[] args){
        Diameter diameter = new Diameter();
        diameter.root = new Node(1);

        diameter.root.left = new Node(2);
        diameter.root.right = new Node(3);

        diameter.root.left.left = new Node(4);
        diameter.root.left.right = new Node(5);
        diameter.root.right.left = new Node(6);
        diameter.root.right.right = new Node(7);
/*
        diameter.root.right.right.right = new Node(8);
*/


        diameter.findDia(diameter.root);


        System.out.println(diameter.maxDia);

    }

}
