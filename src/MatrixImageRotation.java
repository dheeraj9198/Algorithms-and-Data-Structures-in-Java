/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/11/14
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixImageRotation {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] rotated = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //right rotation
                // rotated[col][rows-1-row] = matrix[row][col];
                //left rotation
                rotated[cols-col-1][row] = matrix[row][col];
            }
        }

        for(int col = 0;col<cols;col++){
            for(int row = 0;row<rows;row++){
                 System.out.print(rotated[col][row]+" ");
            }
            System.out.println();
        }
    }
}
