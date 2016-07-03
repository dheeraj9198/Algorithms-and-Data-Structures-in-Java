package BinaryTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class CloneABinaryTree {

    private static void cloneTree(Node oring, Node clone) {
        if (oring == null) {
            return;
        }
        clone.left =oring.left == null ? null : new Node(oring.left.data);
        clone.right =oring.right == null ? null : new Node(oring.right.data);
        cloneTree(oring.left,clone.left);
        cloneTree(oring.right,clone.right);

    }

    public static void main(String[] strings) {
    /*
          10
          /\
         2  10
        /\   \
      20 1   -25
              /\
             3 4
  */
        Node root = new Node(10);

        root.left = new Node(2);
        root.right = new Node(10);

        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);

        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);


        Node cloned = new Node(root.data);
        cloneTree(root,cloned);
        System.out.println();
    }
}
