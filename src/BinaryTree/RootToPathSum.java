package BinaryTree;
/**
 * Created by dheeraj on 7/3/2016.
 */
public class RootToPathSum {

    private static boolean rootToPathSum(Node node,int sum){
            if(node == null){
                return sum ==0;
            }

        boolean left = rootToPathSum(node.left,sum-node.data);
        boolean right = rootToPathSum(node.right,sum-node.data);
        return left || right;
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

        System.out.println(rootToPathSum(root,13));
    }
}
