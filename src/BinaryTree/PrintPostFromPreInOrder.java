package BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 2/28/15
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintPostFromPreInOrder {
    private int[] preorder;
    private int[] inOrder;
    private int preIndex;

    private PrintPostFromPreInOrder(int[] pre, int[] in) {
        preorder = pre;
        inOrder = in;
    }

    private void start() {
        preIndex = 0;
        buildTree(0, preorder.length - 1);
    }

    private void buildTree(int start, int end) {
        if (start > end) {
            return;
        }
        int data = preorder[preIndex++];
        int pos = findPos(data);
        buildTree(start, pos - 1);
        buildTree(pos + 1, end);
        System.out.print(data + " ");
    }

    private int findPos(int data) {
        for (int k = 0; k < inOrder.length; k++) {
            if (inOrder[k] == data) {
                return k;
            }
        }
        throw new RuntimeException("Element not found");
    }

    public static void main(String[] args) {
        PrintPostFromPreInOrder btFromPreInOrder = new PrintPostFromPreInOrder(new int[]{1, 2, 4, 5, 3, 6}
                , new int[]{4, 2, 5, 1, 3, 6});
        btFromPreInOrder.start();
    }
}
