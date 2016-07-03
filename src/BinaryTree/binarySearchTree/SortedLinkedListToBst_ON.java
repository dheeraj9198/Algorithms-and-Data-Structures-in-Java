package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class SortedLinkedListToBst_ON {

    static LLNode llNodeS;

    private static Node makeTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node left = makeTree(start, mid - 1);
        Node root = new Node(llNodeS.data);
        root.left = left;
        llNodeS = llNodeS.llNode;
        root.right = makeTree(mid + 1, end);
        return root;
    }

    private static class LLNode {
        int data;
        LLNode llNode;

        public LLNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] strings) {
        LLNode llroot = new LLNode(7);
        for (int k = 6; k >= 1; k--) {
            LLNode llNode = new LLNode(k);
            llNode.llNode = llroot;
            llroot = llNode;
        }

        llNodeS = llroot;
        Node node = makeTree(0, 6);
        System.out.println();


    }

}
