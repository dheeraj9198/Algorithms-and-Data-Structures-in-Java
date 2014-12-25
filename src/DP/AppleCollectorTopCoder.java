package DP;

/**
 * Created by dheeraj on 12/25/14.
 */
public class AppleCollectorTopCoder {
    private int[][] applesMatrix;
    private int[][] collectionMatrix;
    private int rows;
    private int cols;

    private AppleCollectorTopCoder(int[][] arr){
        this.applesMatrix = arr;
        this.rows = arr.length;
        this.cols = arr[0].length;
        this.collectionMatrix = new int[rows][cols];
    }

    private int findMax(){
        int max = -1;
        for(int x =0;x<rows;x++){
            for(int y=0;y<cols;y++){
                if(x ==0  && y ==0 ){
                    collectionMatrix[x][y] = applesMatrix[x][y];
                    max = collectionMatrix[x][y];
                    continue;
                }else if(x ==0){
                    collectionMatrix[x][y] = collectionMatrix[x][y-1] + applesMatrix[x][y];
                    max = Math.max(max,collectionMatrix[x][y]);
                }else if(y==0){
                    collectionMatrix[x][y] = collectionMatrix[x-1][y] + applesMatrix[x][y];
                    max = Math.max(max,collectionMatrix[x][y]);
                }else{
                    collectionMatrix[x][y] = applesMatrix[x][y] +Math.max(collectionMatrix[x-1][y],collectionMatrix[x][y-1]);
                    max = Math.max(max,collectionMatrix[x][y]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[][] matv = {
                {1,0,2,4,0},
                {0,3,0,1,0},
                {0,9,0,11,0},
                {0,1,0,1,0},
                {0,7,9,11,12},
                {13,9,7,2,1}
        };
        AppleCollectorTopCoder appleCollectorTopCoder = new AppleCollectorTopCoder(matv);
        System.out.println(appleCollectorTopCoder.findMax());
    }


}
