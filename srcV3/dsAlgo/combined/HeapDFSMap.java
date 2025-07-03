package dsAlgo.combined;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Problem: Most Reliable Path with Node Priority
 * <p>
 * You’re given a directed graph with n nodes labeled from 0 to n-1.
 * Each edge has a weight indicating reliability (higher is better).
 * You’re also given a priority value for each node.
 * Find the path from node 0 to node n-1 that:
 * Maximizes reliability (i.e., sum of weights)
 * If multiple paths have the same reliability,
 * prefer the one that visits higher priority nodes earlier (lexicographically higher node priorities)
 * <p>
 * int n = 6;
 * int[][] edges = {
 * {0, 1, 10},
 * {0, 2, 10},
 * {1, 3, 5},
 * {2, 3, 5},
 * {1, 4, 15},
 * {3, 4, 10},
 * {4, 5, 10}
 * };
 * int[] priority = {0-5, 1-7, 2-6, 3-8, 4-5, 5-9};
 * <p>
 * Best path: 0->1->3->4->5
 * <p>
 * 0->1->3->4->5 35 5,7,8,5,9
 * 0->2->3->4->5 35 5,6,8,5,9
 * 0->1->4->5    35 5,7,5,9
 */
public class HeapDFSMap {

    static List<Integer> bestPath = new ArrayList<>();
    static int bestReliability = 0;
    static int[] priority;

    public static List<Integer> test(int nodeCount, int[][] edges, int[] p) {
        priority = p;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < nodeCount; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }


        boolean[] visited = new boolean[nodeCount];
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, visited, nodeCount, path, 0);
        return bestPath;
    }

    public static void dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited, int nodeCount, List<Integer> path, int reliability) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        path.add(node);
        if (node == nodeCount - 1) {
            System.out.println("Possible path : " + Arrays.toString(path.toArray()) + " : " + reliability);
            if (reliability > bestReliability) {
                //System.out.println("Best path high: " + Arrays.toString(path.toArray()) + " : " + reliability);
                bestReliability = reliability;
                bestPath = path;
                return;
            } else if (reliability == bestReliability) {
                for (int i = 0; i < bestPath.size() && i < path.size(); i++) {
                    //System.out.println(priority[path.get(i)] +"->"+ priority[bestPath.get(i)]);
                    if (priority[path.get(i)] > priority[bestPath.get(i)]) {
                        //System.out.println("Best path same: " + Arrays.toString(path.toArray()) + " : " + reliability);
                        bestReliability = reliability;
                        bestPath = path;
                        return;
                    }else if (priority[path.get(i)] < priority[bestPath.get(i)]) {
                        return;
                    }
                }
            }
        }
        for (int[] i : graph.get(node)) {
            boolean[] visitedTemp = Arrays.copyOf(visited, visited.length);
            List<Integer> tempPath = new ArrayList<>(path);
            dfs(i[0], graph, visitedTemp, nodeCount, tempPath, reliability + i[1]);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = 6;
        int[][] edges = {
                {0, 2, 10},
                {0, 1, 10},
                {2, 3, 5},
                {1, 3, 5},
                {1, 4, 15},
                {3, 4, 10},
                {4, 5, 10}
        };
        int[] priority = {5, 7, 6, 8, 5, 9};
        System.out.println(test(n, edges, priority));
    }
}
