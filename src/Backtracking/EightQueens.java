package Backtracking;

/**
 * Created by dheeraj on 28/12/14.
 */
public class EightQueens {

    private final int SIZE = 10;

    private final int safe = 0;
    private final int cut = 1;
    private final int queen = 2;

    private int[][] mat = new int[SIZE][SIZE];

    private EightQueens() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                mat[x][y] = safe;
            }
        }
    }

    private void solveAll(){
        solve(mat);
    }


    private int[][] copy(int[][] mat){
        int[][] test = new int[SIZE][SIZE];
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
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
            return;
        }
        int unsafe;
        for (int x = 0; x < SIZE; x++) {
            unsafe = 0;
            for (int y = 0; y < SIZE; y++) {
                if(matrix[x][y] == safe){

                    int[][] test = copy(matrix);
                    test[x][y] = queen;
                    //mark row
                    for(int z =0 ;z<SIZE;z++){
                        if(z == x){
                            continue;
                        }
                        test[z][y] = cut;
                    }
                    //mark col
                    for(int z =0 ;z<SIZE;z++){
                        if(z == y){
                            continue;
                        }
                        test[x][z] = cut;
                    }

                    //first diagonal
                    int a = x+1;
                    int b = y+1;
                    while(a<SIZE && b <  SIZE){
                        test[a][b] = cut;
                        a++;b++;
                    }
                    a = x-1;
                    b = y-1;
                    while(a>=0 && b >=0){
                        test[a][b] = cut;
                        a--;b--;
                    }

                    //second diagonal
                    a = x+1;
                    b = y-1;
                    while(a<SIZE && b >=  0){
                        test[a][b] = cut;
                        a++;b--;
                    }
                    a = x-1;
                    b = y+1;
                    while(a>=0 && b < SIZE){
                        test[a][b] = cut;
                        a--;b++;
                    }

                    solve(test);
                }else {
                    unsafe++;
                    if(unsafe == SIZE){
                        return;
                    }
                }
            }
        }
    }

    private void printMat(int[][] mat){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                System.out.print(mat[x][y]+" ");
            }
            System.out.println();
        }
        System.out.println("_______________________________________________");
    }

    private boolean solved(int[][] mat) {
        int count = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (mat[x][y] == queen) {
                    count++;
                }
            }
        }
        if (count == SIZE) {
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
