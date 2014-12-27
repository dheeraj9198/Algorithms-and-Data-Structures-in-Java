package Backtracking;

/**
 * Created by dheeraj on 28/12/14.
 */
public class EightQueens {

    private final int safe = 0;
    private final int cut = 1;
    private final int queen = 2;

    private int[][] mat = new int[8][8];
    private int rows = 8;
    private int cols = 8;

    private EightQueens() {
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < cols; y++) {
                mat[x][y] = safe;
            }
        }
    }

    private void solveAll(){
        solve(mat);
    }


    private int[][] copy(int[][] mat){
        int[][] test = new int[rows][cols];
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < cols; y++) {
                test[x][y] = mat[x][y];
            }
        }
        return test;
    }

    private void solve(int[][] matrix) {

       // System.out.println("solving ");
       // printMat(matrix);

        if (solved(matrix)) {
            printMat(matrix);
            System.exit(8);
        }

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < cols; y++) {
                if(matrix[x][y] == safe){

                    int[][] test = copy(matrix);
                    test[x][y] = queen;
                    for(int z =0 ;z<rows;z++){
                        if(z == x){
                            continue;
                        }
                        test[z][y] = cut;
                    }

                    for(int z =0 ;z<cols;z++){
                        if(z == y){
                            continue;
                        }
                        test[x][z] = cut;
                    }

                    int a = x+1;
                    int b = y+1;
                    while(a<rows && b <  cols){
                        test[a][b] = cut;
                        a++;b++;
                    }

                    a = x-1;
                    b = y-1;
                    while(a>=0 && b >=0){
                        test[a][b] = cut;
                        a--;b--;
                    }
                    solve(test);
                }
            }
        }
    }

    private void printMat(int[][] mat){
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < cols; y++) {
                System.out.print(mat[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println("_______________________________________________");
    }

    private boolean solved(int[][] mat) {
        int count = 0;
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < cols; y++) {
                if (mat[x][y] == queen) {
                    count++;
                }
            }
        }
        if (count == 8) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        EightQueens eightQueens = new EightQueens();
        eightQueens.solveAll();
    }

}
