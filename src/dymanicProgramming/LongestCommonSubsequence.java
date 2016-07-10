package dymanicProgramming;

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

    private String findSubSequence(){
        /**
         * move from bottom right corner to top left corner
         */
        StringBuilder stringBuilder = new StringBuilder();
        int r = rows-1;
        int c = cols -1;
        while(r >=1 && c >= 1){
            if(string1.charAt(r-1) == string2.charAt(c-1)){
                stringBuilder.append(string1.charAt(r-1));
            }

            if(mat[r-1][c] > mat[r][c-1]){
                r = r-1;
            }else{
                c = c-1;
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence("ABCDGH","AEDFHR");
        System.out.println(longestCommonSubsequence.findAns());
        System.out.println(longestCommonSubsequence.findSubSequence());
    }


}
