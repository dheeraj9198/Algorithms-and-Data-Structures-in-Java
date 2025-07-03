package dsAlgo.combined;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * You are given a directed graph with N nodes labeled from 0 to N - 1.
 * Each edge in the graph is represented by a tuple [from, to, cost], indicating a one-way connection from from to to with an associated cost.
 * Each node also has a risk score, where risk[i] represents the risk level of node i (lower is safer).
 * Your task is to:
 * Find the K distinct paths from node 0 to node N - 1 that have the minimum total cost.
 * If multiple paths have the same cost, prefer the one where lower-risk nodes appear earlier in the path, based on lexicographic order of their risk scores.
 * If cost and risk score is same shorter path is better.
 * Return a list of the top K such paths. Each path should be represented as a list of node indices in the order they are visited.
 * <p>
 * Input
 * int N — the number of nodes
 * int[][] edges — a list of [from, to, cost] edges
 * int[] risk — an array where risk[i] is the risk score of node i
 * int K — the number of top paths to return
 * <p>
 * Constraints
 * 1 <= N <= 100
 * 0 <= cost <= 1000
 * 0 <= risk[i] <= 1000
 * There is at least one path from node 0 to node N - 1
 * Paths should not revisit the same node (no cycles)
 * All edge costs and risk scores are non-negative
 * <p>
 * N = 5
 * edges = {
 * {0, 1, 2},
 * {0, 2, 2},
 * {1, 3, 2},
 * {2, 3, 2},
 * {3, 4, 2}
 * }
 * risk = {3, 2, 1, 4, 0}
 * K = 2
 * <p>
 * Output:
 * [
 * [0, 2, 3, 4],
 * [0, 1, 3, 4]
 * ]
 */

public class HeapDFSMapAmazon {

    private static AtomicInteger counter = new AtomicInteger(0);

    private static class Path {
        private List<Integer> nodes;
        private Integer cost;

        public Path(Integer cost, List<Integer> nodes) {
            this.cost = cost;
            this.nodes = nodes;
        }
    }

    private static PriorityQueue<Path> pq = new PriorityQueue<Path>(new Comparator<Path>() {

        @Override
        public int compare(Path o1, Path o2) {
            if (!o1.cost.equals(o2.cost)) {
                return o2.cost - o1.cost; // Max-heap: higher cost comes first
            }
            for (int i = 0; i < Math.min(o1.nodes.size(), o2.nodes.size()); i++) {
                int r1 = risk[o1.nodes.get(i)];
                int r2 = risk[o2.nodes.get(i)];
                if (r1 != r2) {
                    return Integer.compare(r2, r1); // Max-heap: higher risk first
                }
            }
            return o2.nodes.size() - o1.nodes.size(); // shorter path is better
        }
    });
    private static Map<Integer, List<int[]>> graph = new HashMap();
    private static int[] risk;
    private static int nodeCount;
    private static int bestPathSize;

    private static void findPaths(int N, int[][] edges, int[] riskArray, int K) {
        nodeCount = N;
        risk = riskArray;
        bestPathSize = K;
        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];
            graph.get(src).add(new int[]{dest, cost});
        }

        dfs(0, 0, new ArrayList<>(), 0, new boolean[N]);
    }

    private static void dfs(int src, int cost, List<Integer> path, int pathcost, boolean[] visited) {
        counter.incrementAndGet();
        if (visited[src]) {
            return;
        }
        visited[src] = true;
        cost = cost + pathcost;
        path.add(src);
        if (src == nodeCount - 1) {
            //destination reached
            if (pq.size() == bestPathSize && cost > pq.peek().cost) {
                //do nothing this is worse then K best paths
                return;
            } else {
                insertIntoHeap(new Path(cost, path));
            }
        }
        if (pq.size() == bestPathSize && cost > pq.peek().cost) {
            return;
        }
        for (int[] edge : graph.get(src)) {
            dfs(edge[0], edge[1], new ArrayList<>(path), cost, visited);
        }
        visited[src] = false; // or do Arrays.copyOf(visited, visited.length)
    }

    private static void insertIntoHeap(Path path) {
        if (pq.size() < bestPathSize) {
            pq.add(path);
        } else {
            pq.poll();
            pq.add(path);
        }
    }

    public static void main(String[] args) {

        int N = 5;
        int[][] edges = new int[][]{
                {0, 1, 2},
                {0, 2, 2},
                {1, 3, 2},
                {2, 3, 2},
                {3, 4, 2}};
        int[] risk = {3, 2, 1, 4, 0};
        int K = 2;
        findPaths(N, edges, risk, K);
        while (!pq.isEmpty()) {
            Path path = pq.poll();
            System.out.println(path.nodes + " " + path.cost);
        }
        System.out.println(counter.get());
    }
}

/**
 * ⏱ Time Complexity
 * 1. Worst-Case DFS Path Exploration
 *
 * You explore all possible paths from 0 to N-1, but with pruning:
 *
 * if (pq.size() == K && cost > pq.peek().cost) return;
 *
 * However, before pq.size() == K, no pruning happens. So in the worst case:
 *
 *     DFS explores all acyclic paths from 0 to N-1
 *
 *     Number of such paths in a DAG can be exponential:
 *
 *         For example, a full branching DAG of depth d has O(b^d) paths
 *
 *         So worst-case DFS path count: O(P), where P is number of valid paths from source to target
 *
 * Let’s denote:
 *
 *     T = number of paths from 0 to N-1 that pass pruning check
 *
 * For each such path:
 *
 *     Heap insertion takes O(log K)
 *
 *     Path copying takes O(L) where L is path length
 *
 * So total time:
 *
 * O(T × (L + log K))
 *
 * In best case, pruning cuts off early (if costs rise quickly), and T is much smaller.
 * 2. Comparator Calls in Heap
 *
 * Each Path is compared based on:
 *
 *     cost → O(1)
 *
 *     risk[] over nodes in path → O(L)
 *
 *     path length → O(1)
 *
 * Each insertion can compare O(log K) times in the heap.
 *
 * So per heap operation:
 * O(L × log K)
 * 💾 Space Complexity
 * 1. Graph:
 *
 * Map<Integer, List<int[]>> graph → O(N + E)
 *
 * 2. Visited + Risk + Other State:
 *
 * visited[] → O(N)
 * risk[] → O(N)
 *
 * 3. Heap (priority queue):
 *
 * Stores up to K paths. Each path stores up to N nodes:
 *
 * O(K × N)
 *
 * 4. DFS Call Stack:
 *
 * In worst case depth N, recursion stack = O(N)
 * ✅ Final Complexity Summary
 * ⏱ Time Complexity:
 *
 *     Worst case:
 *     O(T × (L + log K)), where T = number of pruned-eligible paths from 0 to N-1
 *
 *     Exponential in worst-case DAGs without tight pruning
 *
 *     Efficient if cost pruning removes bad paths early
 *
 * 💾 Space Complexity:
 *
 *     O(K × N + N + E) → heap + graph + visited array
 */