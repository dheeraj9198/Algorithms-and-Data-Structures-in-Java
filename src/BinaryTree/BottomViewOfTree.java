package BinaryTree;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by dheeraj on 28/1/15.
 */
public class BottomViewOfTree {

    private Map<Integer,Integer> integerIntegerTreeMap = new TreeMap<Integer,Integer>();

    private static class Node{
        Node left;
        Node right;
        int data;
        int level;
        private Node(int t){
            this.data = t;
        }
    }

    private Node root;

    private void printBottomView(){
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        root.level = 0;
        integerIntegerTreeMap.put(root.level,root.data);

        Node temp;

        while(!nodes.isEmpty()){
            temp = nodes.remove();

            if(temp.left != null){
                temp.left.level = temp.level -1;
                nodes.add(temp.left);
                integerIntegerTreeMap.put(temp.left.level,temp.left.data);
            }

            if(temp.right != null){
                temp.right.level = temp.level +1;
                nodes.add(temp.right);
                integerIntegerTreeMap.put(temp.right.level,temp.right.data);
            }
        }
    }


    public static void main(String[] args){
        BottomViewOfTree bottomViewOfTree = new BottomViewOfTree();

        bottomViewOfTree.root = new Node(20);

        bottomViewOfTree.root.right = new Node(22);
        bottomViewOfTree.root.left = new Node(8);

        bottomViewOfTree.root.left.left = new Node(5);
        bottomViewOfTree.root.left.right = new Node(3);
        bottomViewOfTree.root.right.right = new Node(25);

        bottomViewOfTree.root.left.right.left = new Node(10);
        bottomViewOfTree.root.left.right.right = new Node(14);

        bottomViewOfTree.printBottomView();

        for(Map.Entry<Integer,Integer> entry : bottomViewOfTree.integerIntegerTreeMap.entrySet()){
            System.out.print(entry.getValue()+ " ");
        }
    }
}
