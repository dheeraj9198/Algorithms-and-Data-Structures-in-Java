package BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 2/28/15
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BTFromPreInOrder {
    private Node root;
    private int[] preorder;
    private int[] inOrder;
    private int preIndex;

    private BTFromPreInOrder(int[] pre, int[] in) {
        preorder = pre;
        inOrder = in;
    }

    private void start(){
        preIndex = 0;
        root = buildTree(0,preorder.length-1);
    }

    private Node buildTree(int start,int end){
           if(start > end){
               return null;
           }
        Node nRoot = new Node(preorder[preIndex++]);
        int pos = findPos(nRoot.data);
        nRoot.left = buildTree(start,pos-1);
        nRoot.right = buildTree(pos+1,end);
        return nRoot;
    }

    private int findPos(int data){
        for(int k =0;k<inOrder.length;k++){
            if (inOrder[k] == data){
                return k;
            }
        }
        return -1;
    }

    private void preOrderTaversal(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        if (root.left != null)
            preOrderTaversal(root.left);
        if (root.right != null)
            preOrderTaversal(root.right);
    }

    public static void main(String[] args){
        BTFromPreInOrder btFromPreInOrder = new BTFromPreInOrder(new int[]{1,2,4,5,3,6},new int[]{4,2,5,1,6,3});
        btFromPreInOrder.start();
        btFromPreInOrder.preOrderTaversal(btFromPreInOrder.root);
    }
}
