/**
 * Created with IntelliJ IDEA.
 * User: dheeraj
 * Date: 7/12/14
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SodukoSolver {
    int[][] matrix;
    int dim;

    public SodukoSolver(int[][] mat) {
        matrix = mat;
        dim = matrix.length;
        System.out.println("dim = "+dim);
    }

    public void solve() {
        solveP(matrix);
    }

    private void solveP(int[][] mat){
        if(solved(mat)){
            printMat(mat);
            System.exit(0);
        }

        for(int x = 0;x<dim;x++){
            for(int y=0;y<dim;y++){
                if(mat[x][y] == 0){
                    for(int j = 1;j<=9;j++){
                        if(checkIfValid(mat,x,y,j))
                        {
                            int[][] newMat = copyMat(mat);
                            newMat[x][y] = j;
                            solveP(newMat);
                        }
                    }
                    return;
                }
            }
        }
    }

    private int[][] copyMat(int[][] mat){
        int[][] newMat = new int[dim][dim];
        for(int i=0;i<dim;i++){
            for(int j =0;j<dim;j++){
                newMat[i][j] = mat[i][j];
            }
        }
        return newMat;
    }

    private boolean solved(int[][] mat){
        for(int x =0;x<dim;x++)
        {
            for(int y = 0;y<dim;y++){
                if(mat[x][y] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private void printMat(int[][] mat){
        for(int x =0;x<dim;x++)
        {
            for(int y = 0;y<dim;y++){
                System.out.print(mat[x][y]+" ");
            }
            System.out.println();
        }
    }

    private boolean checkIfValid(int[][] mat,int x,int y,int value)
    {
        //System.out.println("Checking if "+value+" is valid at" + x + "X"+y+" value = ");
        //printMat(mat);
        boolean result = true;
        //check row col 3x3 grid
        for(int k =0;k<dim;k++){
            if(mat[k][y] == value){
                //System.out.println("col invalid");
                result = false;
                break;
            }
        }

        for(int k =0;k<dim;k++){
            if(mat[x][k] == value){
                //System.out.println("row invalid");
                result = false;
                break;
            }
        }

        int smallX = (x / (dim/3)) * 3;
        int smallY = (y /(dim/3))*3;

        for(int i=smallX;i< smallX + 3;i++){
            for(int j = smallY;j< smallY + 3;j++){
                if(mat[i][j] == value){
                    //System.out.println("grid invalid "+i+"x"+j);
                    result = false;
                    break;
                }
            }
        }
        //System.out.println("result = "+(result ? "true" : "false"));
        return result;
    }


    public static void main(String[] args){
    /*    int myMat[][] = {
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };*/

        int myMat[][] = {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };


        SodukoSolver sodukoSolver = new SodukoSolver(myMat);
        sodukoSolver.solve();
    }



}
