package BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 2/28/15
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BTFromPostInOrder {
    private Node root;
    private int[] postOrder;
    private int[] inOrder;
    private int postIndex;

    private BTFromPostInOrder(int[] post, int[] in) {
        postOrder = post;
        inOrder = in;
    }

    private void start() {
        postIndex = inOrder.length-1;
        root = buildTree(0, postOrder.length - 1);
    }

    private Node buildTree(int start, int end) {
        if (start > end ) {
            return null;
        }
        Node nRoot = new Node(postOrder[postIndex--]);
        int pos = findPos(nRoot.data);
        nRoot.right = buildTree(pos + 1, end);
        nRoot.left = buildTree(start, pos - 1);
        return nRoot;
    }

    private int findPos(int data) {
        for (int k = 0; k < inOrder.length; k++) {
            if (inOrder[k] == data) {
                return k;
            }
        }
        throw new RuntimeException("Element not found");
    }

    private void inOrderTaversal(Node root) {
        if (root == null) return;
        if (root.left != null)
            inOrderTaversal(root.left);
        System.out.print(root.data+" ");
        if (root.right != null)
            inOrderTaversal(root.right);
    }

    public static void main(String[] args) {
        BTFromPostInOrder btFromPreInOrder = new BTFromPostInOrder(new int[]{1,3,2,5,7,6,4}, new int[]{1, 2,3,4,5, 6, 7});
        btFromPreInOrder.start();
        btFromPreInOrder.inOrderTaversal(btFromPreInOrder.root);
    }
}
