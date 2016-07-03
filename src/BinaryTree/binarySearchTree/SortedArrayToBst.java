package BinaryTree.binarySearchTree;

/**
 * Created by dheeraj on 7/3/2016.
 */
public class SortedArrayToBst {

    public static Node makeTree(int[] array,int start,int end)
    {
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node node = new Node(array[mid]);
        node.left = makeTree(array,start,mid-1);
        node.right = makeTree(array,mid+1,end);
        return node;
    }

    public static void main(String[] strings){
             int[] ints = new int[]{1,2,3,4,5,6,7};
        Node node = makeTree(ints,0,ints.length-1);
        System.out.println();


    }

}
