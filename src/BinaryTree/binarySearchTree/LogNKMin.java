package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 6/27/2016.
 */
public class LogNKMin {

    static class Node {
        int data;
        int leftSize;
        Node left, right;

        public Node(int data, int leftSize) {
            this.data = data;
            this.leftSize = leftSize;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data, 0);
        }
        if (root.data < data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
            root.leftSize++;
        }
        return root;
    }

    static int findKthSmallest(Node root,int k){
        if(root.leftSize == k-1){
            return root.data;
        }else if(root.leftSize > k-1 ){
            return findKthSmallest(root.left,k);
        }else{
            return findKthSmallest(root.right,k-root.leftSize-1);
        }
    }


    public static void main(String[] strings) {
        Node root = insert(null, 5);
        insert(root, 3);
        insert(root, 4);
        insert(root, 2);
        insert(root, 1);
        insert(root, 6);
        System.out.println("");
        System.out.println(findKthSmallest(root,6));
    }

}
