package Graph;

import java.util.ArrayList;

/**
 * Created by dheeraj on 30/12/14.
 */
public class HamiltonianPath {
    private int[][] graph;
    private ArrayList<ArrayList<Integer>> hamiltonianCycle;
    private int dim;
    private boolean[] visited;

    public HamiltonianPath(int[][] g) {
        graph = g;
        dim = g.length;
        hamiltonianCycle = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[dim];
    }

    private void initBoolean() {
        for (int x = 0; x < dim; x++) {
            visited[x] = false;
        }
    }

    private void solve() {
        for (int x = 0; x < dim; x++) {
            initBoolean();
            DFS(x,x,copyArr(visited));
            System.out.println();
        }
    }

    private boolean allVisited(boolean[] visited) {
        for (int x = 0; x < dim; x++) {
            if (!visited[x]) {
                return false;
            }
        }
        return true;
    }

    private boolean[] copyArr(boolean[] ar){
        boolean[] copy = new  boolean[ar.length];
        for(int x =0;x<copy.length;x++){
            copy[x]= ar[x];
        }
        return copy;
    }

    private boolean DFS(int parent, int root,boolean[] visited) {
        if (parent == root && allVisited(visited)) {
            System.out.print(parent + " ");
            return true;
        }
        if (visited[parent]) {
            return false;
        }

        visited[parent] = true;
        for (int x = 0; x < dim; x++) {
            if (graph[parent][x] == 1) {
                if (DFS(x,root,copyArr(visited))) {
                    System.out.print(parent + " ");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        HamiltonianPath hamiltonianPath = new HamiltonianPath(mat);
        hamiltonianPath.solve();
    }


}
