package Graph;

/**
 * Created by dheeraj on 1/1/15.
 */
public class ShortestPathWithExactlyKEdges {

    private static final int INFINITE = Integer.MAX_VALUE;

    private int[][] matrix;

    private int source;
    private int destination;
    private int edgeCount;

    private int answer = INFINITE;

    public ShortestPathWithExactlyKEdges(int[][] mat,int source,int destination,int edgeCount){
        this.matrix = mat;
        this.edgeCount = edgeCount;
        this.source = source;
        this.destination = destination;
    }

    private void findAns(){
        DFS(source, 0, 0);
        System.out.println(answer);
    }

    private void DFS(int parent,int depth,int distance){
        //System.out.println(parent + " " + depth+" "+distance);
        if(depth >= edgeCount ){
            return;
        }

        for(int j=0;j<matrix.length;j++){
            if(matrix[parent][j] != INFINITE){
                if(depth == edgeCount-1 && j==destination){
                    answer = Math.min(answer,distance+matrix[parent][j]);
                }
                DFS(j,depth+1,distance+matrix[parent][j]);
            }
        }

    }



    public static void main(String[] args) {
        int[][] matrix = {{INFINITE, 10, 3, 2},
                {INFINITE, INFINITE, INFINITE, 7},
                {INFINITE, INFINITE, INFINITE, 6},
                {INFINITE, INFINITE, INFINITE, INFINITE}
        };

        ShortestPathWithExactlyKEdges shortestPathWithExactlyKEdges = new ShortestPathWithExactlyKEdges(matrix,0,3,2);
        shortestPathWithExactlyKEdges.findAns();


    }

}
