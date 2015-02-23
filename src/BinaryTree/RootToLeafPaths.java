package BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dheeraj on 24/2/15.
 */
public class RootToLeafPaths {
    private Node root;

    private void findPath(Node root,Queue<Integer> integerQueue){
        if(root.left == null && root.right == null){
            integerQueue.add(root.data);
            while(!integerQueue.isEmpty()){
                System.out.print(integerQueue.remove()+" ");
            }
            System.out.println();
            return;
        }
        if(root.left != null){
            findPath(root.left,copyQueue(integerQueue,root.data));
        }

        if(root.right != null){
            findPath(root.right,copyQueue(integerQueue,root.data));
        }

    }

    private Queue<Integer> copyQueue(Queue<Integer> queue,int d){
        Queue<Integer> integerQueue = new LinkedList<Integer>();
        Iterator<Integer> integerIterator = queue.iterator();
        while(integerIterator.hasNext()){
            integerQueue.add(integerIterator.next());
        }
        integerQueue.add(d);
        return integerQueue;
    }

    public static void main(String[] args){
        RootToLeafPaths rootToLeafPaths = new RootToLeafPaths();
        rootToLeafPaths.root = new Node(1);

        rootToLeafPaths.root.left = new Node(2);
        rootToLeafPaths.root.right = new Node(3);

        rootToLeafPaths.root.left.left = new Node(4);
        rootToLeafPaths.root.left.right = new Node(5);
        rootToLeafPaths.root.right.left = new Node(6);
        rootToLeafPaths.root.right.right = new Node(7);
        rootToLeafPaths.root.right.right.right = new Node(8);
        rootToLeafPaths.findPath(rootToLeafPaths.root, new LinkedList<Integer>());

    }
}
