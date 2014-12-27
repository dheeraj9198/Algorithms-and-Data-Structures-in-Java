package DP;

/**
 * Created by dheeraj on 27/12/14.
 */
public class LongestCommonSubsequence {
    private String string1,string2;
    private int rows;
    private int cols;
    private int[][] mat;

    private int ans = 0;

    private LongestCommonSubsequence(String s1,String s2){
        string1 = s1;
        string2 = s2;

        rows = string1.length()+1;
        cols = string2.length()+1;

        mat = new int[rows][cols];

        for(int x=0;x<rows;x++){
            mat[x][0] = 0;
        }

        for(int x=0;x<cols;x++){
            mat[0][x] = 0;
        }
    }

    private int findAns(){
        for(int x =1;x<rows;x++){
            for(int y=1;y<cols;y++){
                if(string1.charAt(x-1) == string2.charAt(y-1)){
                    mat[x][y] = Math.max(mat[x-1][y],mat[x][y-1]) + 1;
                    ans = Math.max(ans,mat[x][y]);
                }else{
                    mat[x][y] = Math.max(mat[x-1][y],mat[x][y-1]);
                    ans = Math.max(ans,mat[x][y]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence("acd","abcxd");
        System.out.println(longestCommonSubsequence.findAns());
    }


}
