/**
 * Created with IntelliJ IDEA.
 * User: naveen
 * Date: 7/12/14
 * Time: 7:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BST {
    Node root;
    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int value){
            left = null;
            right = null;
            data = value;
        }
    }

    public BST(){
        root = null;
    }

    public void insert(int data)
    {
        root = insertP(root,data);
    }

    private Node insertP(Node root,int data){
         if(root == null){
             root = new Node(data);
             return root;
         }else{
             if(data > root.data){
                 root.right = insertP(root.right,data);
             }else{
                 root.left = insertP(root.left,data);
             }
         }
        return root;
    }


    public void inOrder(){
        inOrderP(root);
    }

    private void inOrderP(Node root){
        if(root == null)
        {
            return;
        }else{
            inOrderP(root.left);
            System.out.println(root.data+" ");
            inOrderP(root.right);
        }
    }

    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(40);
        bst.insert(30);
        bst.insert(50);
        bst.insert(25);
        bst.insert(35);
        bst.insert(55);
        bst.insert(60);

        bst.inOrder();


    }







}
