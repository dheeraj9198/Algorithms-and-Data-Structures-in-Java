package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dheeraj on 31/12/14.
 *
 * https://www.geeksforgeeks.org/snake-ladder-problem-2/
 *
 * Snake and Ladder Problem
 * Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell. Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.
 * If the player reaches a cell which is base of a ladder, the player has to climb up that ladder and if reaches a cell is mouth of the snake, has to go down to the tail of snake without a dice throw.
 * The idea is to consider the given snake and ladder board as a directed graph with number of vertices equal to the number of cells in the board. The problem reduces to finding the shortest path in a graph. Every vertex of the graph has an edge to next six vertices if next 6 vertices do not have a snake or ladder. If any of the next six vertices has a snake or ladder, then the edge from current vertex goes to the top of the ladder or tail of the snake. Since all edges are of equal weight, we can efficiently find shortest path using Breadth First Search of the graph.
 *
 * Following is the implementation of the above idea. The input is represented by two things, first is ‘N’ which is number of cells in the given board, second is an array ‘move[0…N-1]’ of size N. An entry move[i] is -1 if there is no snake and no ladder from i, otherwise move[i] contains index of destination cell for the snake or the ladder at i.
 */
public class SnakeLadder {
    private HashMap<Integer, Integer> jumpMap = new HashMap<Integer, Integer>();

    private int[] distance;
    private boolean[] visited;

    private SnakeLadder(int size) {
        size++;
        distance = new int[size];
        visited = new boolean[size];
        for (int x = 0; x < size; x++) {
            distance[x] = Integer.MAX_VALUE;
            visited[x] = false;

        }
    }

    private void BFS() {
        distance[0] = 0;
        Queue<Integer> integerQueue = new LinkedList<Integer>();
        integerQueue.add(0);
        while (!integerQueue.isEmpty()) {
            int x = integerQueue.remove();
            visited[x] = true;
            if (jumpMap.containsKey(x) && !visited[jumpMap.get(x)]) {
                distance[jumpMap.get(x)] = Math.min(distance[jumpMap.get(x)], distance[x]);
                integerQueue.add(distance[jumpMap.get(x)]);
            }
            for (int k = Math.min(x + 1, distance.length - 1); k <= Math.min(x + 6, distance.length - 1); k++) {
                if(!visited[k]) {
                    distance[k] = Math.min(distance[k], distance[x] + 1);
                    integerQueue.add(k);
                }
            }
        }
        System.out.println(distance[distance.length - 1]);
    }

    public static void main(String[] args) {
        SnakeLadder snakeLadder = new SnakeLadder(30);
        snakeLadder.jumpMap.put(3, 22);
        snakeLadder.jumpMap.put(5, 8);
        snakeLadder.jumpMap.put(11, 26);
        snakeLadder.jumpMap.put(20, 29);
        snakeLadder.jumpMap.put(21, 9);
        snakeLadder.jumpMap.put(19, 7);
        snakeLadder.jumpMap.put(17, 4);
        snakeLadder.jumpMap.put(27, 1);

        snakeLadder.BFS();
    }

}
