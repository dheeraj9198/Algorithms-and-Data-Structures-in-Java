package Graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by dheeraj on 31/12/14.
 */
public class AdjancyListDfs {

    private HashMap<Integer, LinkedList<Integer>> adjancyList;
    private HashMap<Integer, Boolean> visited;

    private AdjancyListDfs() {
        adjancyList = new HashMap<Integer, LinkedList<Integer>>();
        visited = new HashMap<Integer, Boolean>();
    }

    private void addNode(int parent, int child) {
        if (adjancyList.containsKey(parent)) {
            adjancyList.get(parent).add(child);
        } else {
            LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
            integerLinkedList.add(child);
            adjancyList.put(parent, integerLinkedList);
        }

        visited.put(parent, false);
        visited.put(child, false);
    }

    private void beginDFS() {
     /*   for(Integer integer : adjancyList.keySet()){
            if(!visited.get(integer)){
                DFS(integer);
            }
        }*/
        DFS(2);
    }

    private void DFS(Integer integer) {

        visited.put(integer, true);
        System.out.print(integer + " ");

        for (Integer integer1 : adjancyList.get(integer)) {
            if (!visited.get(integer1)) {
                DFS(integer1);
            }
        }
    }

    public static void main(String[] args) {
        AdjancyListDfs adjancyListDfs = new AdjancyListDfs();
        adjancyListDfs.addNode(0, 1);
        adjancyListDfs.addNode(0, 2);
        adjancyListDfs.addNode(1, 2);
        adjancyListDfs.addNode(2, 0);
        adjancyListDfs.addNode(2, 3);
        adjancyListDfs.addNode(3, 3);

        adjancyListDfs.beginDFS();
    }


}
