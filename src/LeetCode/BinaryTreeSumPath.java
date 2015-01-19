package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dheeraj on 19/1/15.
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf
 * path such that adding up all the values along the path equals the given sum.
 */
public class BinaryTreeSumPath {

    private TreeNode root;

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        private TreeNode(int data){
            this.left = null;
            this.right = null;
            this.val = data;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> TreeNodeQueue = new LinkedList<TreeNode>();
        TreeNodeQueue.add(root);
        TreeNode temp;

        while(!TreeNodeQueue.isEmpty()){
            temp = TreeNodeQueue.remove();
            if(temp.val == sum && temp.left == null && temp.right == null){
                return true;
            }else{
                if(temp.left != null){
                    temp.left.val = temp.left.val+ temp.val;
                    TreeNodeQueue.add(temp.left);
                }
                if(temp.right != null){
                    temp.right.val = temp.right.val+ temp.val;
                    TreeNodeQueue.add(temp.right);
                }
            }
        }
        return false;

    }

    public static void main(String[] args){



        BinaryTreeSumPath binaryTreeSumPath = new BinaryTreeSumPath();
        binaryTreeSumPath.root = new TreeNode(5);

        binaryTreeSumPath.root.left = new TreeNode(4);
        binaryTreeSumPath.root.right = new TreeNode(8);

        binaryTreeSumPath.root.left.left = new TreeNode(11);
        binaryTreeSumPath.root.right.left = new TreeNode(13);
        binaryTreeSumPath.root.right.right = new TreeNode(4);

        binaryTreeSumPath.root.left.left.left = new TreeNode(7);
        binaryTreeSumPath.root.left.left.right = new TreeNode(2);
        binaryTreeSumPath.root.right.right.right = new TreeNode(1);

        System.out.print(binaryTreeSumPath.hasPathSum(binaryTreeSumPath.root, 22) ? "yes" : "no");






    }

}
