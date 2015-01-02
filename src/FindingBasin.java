import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dheeraj on 12/16/14.
 */
public class FindingBasin {
    int[][] matrix;
    int rows;
    int cols;

    PriorityQueue<RowColHeight> rowColHeightPriorityQueue;

    private static class RowColHeight {
        int row;
        int col;
        int height;

        public RowColHeight(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public boolean equals(Object obj) {
            RowColHeight obj1 = (RowColHeight) obj;
            if(obj1.row == this.row && obj1.col == this.col){
                return true;
            }else{
                return false;
            }
        }


    }

    public FindingBasin(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public void findBasin() {
        rowColHeightPriorityQueue = new PriorityQueue<RowColHeight>(rows * cols, new Comparator<RowColHeight>() {
            @Override
            public int compare(RowColHeight o1, RowColHeight o2) {
                return o1.height - o2.height;
            }
        });

        // basin matrix -> true basin , false non basin
        boolean[][] basinMatrix = new boolean[rows][cols];
        boolean[][] visitedMatrix = new boolean[rows][cols];
        // sort matrix data on the basis of heights
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                rowColHeightPriorityQueue.add(new RowColHeight(x, y, matrix[x][y]));
                basinMatrix[x][y] = true;
                visitedMatrix[x][y] = false;
            }
        }

        RowColHeight rowColHeight;

        while (!rowColHeightPriorityQueue.isEmpty()) {
            //find all non basins
            rowColHeight = rowColHeightPriorityQueue.remove();

            for (int x = Math.max(0, rowColHeight.row - 1); x < Math.min(rows, rowColHeight.row + 2); x++) {
                for (int y = Math.max(0, rowColHeight.col - 1); y < Math.min(cols, rowColHeight.col + 2); y++) {
                    if (x == rowColHeight.row && y == rowColHeight.col) {
                        continue;
                    }

                    if (visitedMatrix[x][y]) {
                        continue;
                    } else {
                        visitedMatrix[x][y] = true;
                    }

                    if (matrix[x][y] > rowColHeight.height) {
                        basinMatrix[x][y] = false;
                        //matrix[x][y] is non basin so all its neighbours >= it are also non basins
                        //DFS :)
                        markALlNonBasins(rowColHeightPriorityQueue,visitedMatrix,basinMatrix,x,y);
                    }
                }
            }
        }
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                System.out.print(basinMatrix[x][y] + " ");
            }
            System.out.println();
        }
    }

    private void markALlNonBasins(PriorityQueue<RowColHeight> rowColHeightPriorityQueue,boolean[][] visitedMatrix,boolean[][] basinMatrix,int row,int column) {

        for (int x = Math.max(0,row - 1); x < Math.min(rows,row + 2); x++) {
            for (int y = Math.max(0,column - 1); y < Math.min(cols,column + 2); y++) {
                if (x == row && y == column) {
                    continue;
                }

                if(visitedMatrix[x][y]){
                    continue;
                }

                if(matrix[x][y] >= matrix[row][column]){
                    visitedMatrix[x][y] = true;
                    basinMatrix[x][y] =false;
                    rowColHeightPriorityQueue.remove(new RowColHeight(x,y,matrix[x][y]));
                    markALlNonBasins(rowColHeightPriorityQueue,visitedMatrix,basinMatrix,x,y);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 9, 8, 7, 7},
                {8, 8, 7, 7, 7, 8},
                {8, 8, 8, 7, 7, 7},
                {8, 8, 8, 9, 9, 9},
                {8, 8, 8, 7, 7, 7},
                {4, 4, 5, 5, 5, 5},
                {5, 5, 5, 6, 6, 7},
                {5, 5, 5, 8, 8, 6}
        };

        FindingBasin findingBasin = new FindingBasin(matrix);
        findingBasin.findBasin();


    }
}