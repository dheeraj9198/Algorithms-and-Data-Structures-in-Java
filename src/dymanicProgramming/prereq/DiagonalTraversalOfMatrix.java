package dymanicProgramming.prereq;

/**
 * Created by dheeraj on 7/18/2016.
 * needed for filling matrix chain
 */
public class DiagonalTraversalOfMatrix {

    private static void printDiagonal(int[][] ints) {
        int row = 1;
        int col = 2;
        while (col < ints[0].length) {
            int rowTemp = row;
            int colTemp = col;
            while (colTemp < ints[0].length) {
                System.out.print(ints[rowTemp][colTemp] + " ");
                rowTemp++;
                colTemp++;
            }
            row++;
            col = row + 1;
        }
    }

    private static void printDiagonalOpt(int[][] ints) {
        for (int col =2;col < ints[0].length;col++) {
            int rowTemp = 1;
            for (int colTemp = col;colTemp < ints[0].length;colTemp++) {
                System.out.print(ints[rowTemp][colTemp] + " ");
                rowTemp++;
            }
        }
    }

    public static void main(String[] strings) {
        int[][] mat = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printDiagonal(mat);
    }
}
