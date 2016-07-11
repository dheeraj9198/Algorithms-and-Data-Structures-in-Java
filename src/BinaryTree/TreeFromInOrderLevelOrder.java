package BinaryTree;

/**
 * Created by dheeraj on 7/9/2016.
 */
public class TreeFromInOrderLevelOrder {
    static int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
    static int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};

    static Node makeTree(int start, int end, int rootDataIndex) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(level[rootDataIndex]);
        }
        Node root = new Node(level[rootDataIndex]);
        //find that node in inorder travesal
        int mid = -1;
        for (int x = start; x <= end; x++) {
            if (level[rootDataIndex] == in[x]) {
                mid = x;
                break;
            }
        }

        int left = -1;
        //search first elment in level order which is
        // present in pre order,that level order element is left root
        for (int y = 0; y <= level.length - 1; y++) {
            for (int x = start; x <= mid - 1; x++) {
                if (level[y] == in[x]) {
                    left = y;
                    break;
                }
            }
            if (left != -1) {
                break;
            }
        }
        int right = -1;
        for (int y = 0; y <= level.length - 1; y++) {
            for (int x = mid + 1; x <= end; x++) {
                if (level[y] == in[x]) {
                    right = y;
                    break;
                }
            }
            if (right != -1) {
                break;
            }
        }
        if ((left != -1)) {
            root.left = makeTree(start, mid - 1, left);
        }
        if (right != -1) {
            root.right = makeTree(mid + 1, end, right);
        }
        return root;
    }


    public static void main(String[] strings) {
        Node node = makeTree(0, in.length - 1, 0);
        System.out.println();
    }
}
