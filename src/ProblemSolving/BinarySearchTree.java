package ProblemSolving;

/**
 * Created by sujeet on 1/12/14.
 */
public class BinarySearchTree {

    public static class Node
    {
        Node leftNode;
        Node rightNode;
        int value;

        public Node(int data)
        {
            leftNode = null;
            rightNode = null;
            value = data;
        }
    }

    public static class BST{
        Node root;
        void insert(int data)
        {
            if(root == null)
            {
                root = new Node(data);
                return;
            }else{
                if(root.value < data)
                {
                    insertData(root.leftNode, data);
                }else{
                    insertData(root.rightNode, data);
                }
            }
        } 
    }

    public static void main(String[] args)
    {
        int[] array = {20,10,30,8,15,25,40,7,9,14,16,24,26,45,50};
        BST bst = new BST();
        for(int x = 0;x<array.length;x++)
        {
            bst.insert(array[x]);
        }
        preOrder(bst.root);
    }

    static void preOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.print(node.value+" ");
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

}
