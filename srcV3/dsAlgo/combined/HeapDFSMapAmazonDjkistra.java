package dsAlgo.combined;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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

public class HeapDFSMapAmazonDjkistra {

    static class Path {
        List<Integer> nodes;
        int cost;

        public Path(int cost, List<Integer> nodes) {
            this.cost = cost;
            this.nodes = nodes;
        }
    }

    static class State {
        int node;
        int cost;
        List<Integer> path;

        public State(int node, int cost, List<Integer> path) {
            this.node = node;
            this.cost = cost;
            this.path = path;
        }
    }

    public static List<Path> findKBestPaths(int N, int[][] edges, int[] risk, int K) {
        // Build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]}); // {dest, cost}
        }

        // Min-heap: prioritize lower cost, then lexicographic risk
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost != b.cost) return Integer.compare(a.cost, b.cost);
            // Tie-break by lexicographic risk
            int len = Math.min(a.path.size(), b.path.size());
            for (int i = 0; i < len; i++) {
                int r1 = risk[a.path.get(i)];
                int r2 = risk[b.path.get(i)];
                if (r1 != r2) return Integer.compare(r1, r2);
            }
            return Integer.compare(a.path.size(), b.path.size()); // shorter is better
        });

        pq.offer(new State(0, 0, new ArrayList<>(Collections.singletonList(0))));

        List<Path> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < K) {
            State curr = pq.poll();
            int node = curr.node;

            // Count visits to destination
            if (node == N - 1) {
                result.add(new Path(curr.cost, curr.path));
                continue;
            }

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int newCost = curr.cost + edge[1];

                List<Integer> newPath = new ArrayList<>(curr.path);
                newPath.add(next);

                pq.offer(new State(next, newCost, newPath));
            }
        }

        return result;
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
        List<Path> pathList = findKBestPaths(N, edges, risk, K);
        for (Path path : pathList) {
            System.out.println(path.nodes + " " + path.cost);
        }
    }
}
