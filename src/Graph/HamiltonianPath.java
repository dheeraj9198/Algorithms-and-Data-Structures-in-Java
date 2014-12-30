package Graph;
/**
 * Created by dheeraj on 30/12/14.
 */
public class HamiltonianPath {
    private int[][] graph;
    private int dim;
    private boolean[] visited;

    public HamiltonianPath(int[][] g) {
        graph = g;
        dim = g.length;
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
            DFS(x,x,visited.clone());
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
                if (DFS(x,root,visited.clone())) {
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
