package BinaryTree;


/**
 * Created by dheeraj on 7/1/2016.
 */
public class CheckIfHeightBalancedBt {

    static class Data{
        private int height;
        private boolean balanced;

        public Data(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    private static Data checkIfHeightBalanced(Node node){
           if(node == null){
               return new Data(0,true);
           }else if(node.left == null && node.right == null){
               return new Data(1,true);
           }

        Data leftData = checkIfHeightBalanced(node.left);
        Data rightData = checkIfHeightBalanced(node.right);

        if(leftData.balanced && rightData.balanced && Math.abs(leftData.height - rightData.height) <=1){
                 return new Data(Math.max(leftData.height,rightData.height)+1,true);
        }
        return new Data(0,false);
    }

    public static void main(String[] strings) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(7);

        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        root.left.left.left = new Node(9);
        root.left.left.left.left = new Node(999);


        System.out.println(checkIfHeightBalanced(root).balanced);

    }

}
