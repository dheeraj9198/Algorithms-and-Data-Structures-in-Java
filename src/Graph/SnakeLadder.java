package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dheeraj on 31/12/14.
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
