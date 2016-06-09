package DP;

/**
 * Created by dheeraj on 12/25/14.
 */

/*A table composed of N x M cells, each having a certain quantity of apples, is given.
        You start from the upper-left corner. At each step you can go down or right one cell. Find the maximum number of apples you can collect.
        This problem is solved in the same way as other DP problems; there is almost no difference.
        First of all we have to find a state. The first thing that must be observed is that there are at most
        2 ways we can come to a cell – from the left (if it’s not situated on the first column) and from the top
        (if it’s not situated on the most upper row). Thus to find the best solution for that cell, we have to have
        already found the best solutions for all of the cells from which we can arrive to the current cell.
        From above, a recurrent relation can be easily obtained:
        S[i][j]=A[i][j] + max(S[i-1][j], if i>0 ; S[i][j-1], if j>0) (where i represents the row and j the column of
        the table , its left-upper corner having coordinates {0,0} ; and A[i][j] being the number of apples situated in cell i,j).
        S[i][j] must be calculated by going first from left to right in each row and process the rows from top to bottom,
        or by going first from top to bottom in each column and process the columns from left to right.*/


public class AppleCollectorTopCoder {
    private int[][] applesMatrix;
    private int[][] collectionMatrix;
    private int rows;
    private int cols;

    private AppleCollectorTopCoder(int[][] arr) {
        this.applesMatrix = arr;
        this.rows = arr.length;
        this.cols = arr[0].length;
        this.collectionMatrix = new int[rows][cols];
    }

    private int findMax() {
        int max = -1;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (x == 0 && y == 0) {
                    collectionMatrix[x][y] = applesMatrix[x][y];
                    max = collectionMatrix[x][y];
                    continue;
                } else if (x == 0) {
                    collectionMatrix[x][y] = collectionMatrix[x][y - 1] + applesMatrix[x][y];
                    max = Math.max(max, collectionMatrix[x][y]);
                } else if (y == 0) {
                    collectionMatrix[x][y] = collectionMatrix[x - 1][y] + applesMatrix[x][y];
                    max = Math.max(max, collectionMatrix[x][y]);
                } else {
                    collectionMatrix[x][y] = applesMatrix[x][y] + Math.max(collectionMatrix[x - 1][y], collectionMatrix[x][y - 1]);
                    max = Math.max(max, collectionMatrix[x][y]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matv = {
                {1, 0, 2, 4, 0},
                {0, 3, 0, 1, 0},
                {0, 9, 0, 11, 0},
                {0, 1, 0, 1, 0},
                {0, 7, 9, 11, 12},
                {13, 9, 7, 2, 1}
        };
        AppleCollectorTopCoder appleCollectorTopCoder = new AppleCollectorTopCoder(matv);
        System.out.println(appleCollectorTopCoder.findMax());
    }


}
