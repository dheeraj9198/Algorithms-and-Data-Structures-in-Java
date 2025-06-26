package dsAlgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 Let’s assume that there are a total of n courses labeled from 0 to n−1. Some courses may have prerequisites.
 A list of prerequisites is specified such that if Prerequisites.i=a,b, you must take course b before course a.
 Given the total number of courses nn and a list of the prerequisite pairs, return the course order a student
 should take to finish all of the courses. If there are multiple valid orderings of courses, then the return any one of them.
 Note: There can be a course in the 0 to n−1 range with no prerequisites.
 Constraints:
 Let n be the number of courses.
 1≤n≤1500
 0≤ prerequisites.length ≤1000
 prerequisites[i].length ==2
 0≤a, b<n
 a≠b
 All the pairs [a, b][a, b] are distinct.
 */
public class TopSort {

    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        HashMap<Integer, Boolean> visited =  new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        for (int i = 0; i < n; i++) {
            visited.put(i, false);
            graph.put(i, new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        try {
            for (Integer i : graph.keySet()) {
                visit(i, visited, graph, order, visiting);
            }
            return order;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    private static void visit(int node, HashMap<Integer, Boolean> visited, HashMap<Integer, List<Integer>> graph, List<Integer> order, Set<Integer> visiting) {
        if(visiting.contains(node)) throw new RuntimeException("Duplicate node");
        if(visited.get(node)) {
            return;
        }
        visiting.add(node);
        for(int x : graph.get(node)) {
            visit(x, visited, graph, order, visiting);
        }
        order.add(node);
        visited.put(node, true);
        visiting.remove(node);
    }

    public static void main(String[] args){
        int[][] answers = {
                {0, 1, 2, 3},
                {0, 1, 2, 3, 4},
                {0, 1},
                {0, 1, 2, 3},
                {6, 5, 4, 2, 3, 0, 1}
        };
        int[]n = {4, 5, 2, 4, 7};
        int[][][]prerequisites = {
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {2, 0}, {3, 1},{4, 3}},
                {{1, 0}},
                {{1, 0}, {2, 0}, {3, 1}, {3, 2}},
                {{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}},
                {{5,8},{3,5},{1,9},{4,5},{0,2},{7,8},{4,9}}
        
        };
        for(int i=0; i<n.length; i++){
            System.out.print(i+1);
            List<Integer> result = findOrder(n[i], prerequisites[i]);
            if(!Arrays.equals(result.stream().mapToInt(Integer::intValue).toArray(), answers[i])){
                System.out.println("Failed");
                System.out.println(Arrays.toString(answers[i]));
                System.out.println(result);
            }else {
                System.out.println("Passed");
            }
        }

    }

}
