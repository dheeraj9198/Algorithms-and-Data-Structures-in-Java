package DP;

import java.util.Stack;

/**
 * Created by dheeraj on 7/9/2016.
 */
public class LCS {

    private static Integer sol[][];

    private static int findLis(String one, String two, int start, int end) {
        if(start < 0 || start > one.length()-1 || end > two.length()-1 || end <  0){
            return 0;
        }
        if (sol[start][end] != null) {
            return sol[start][end];
        }
        int a = findLis(one, two, start - 1, end - 1);
        int b = findLis(one, two, start - 1, end);
        int c = findLis(one, two, start, end - 1);

        int ans = one.charAt(start) == two.charAt(end) ? a + 1 : Math.max(b, c);
        sol[start][end] = ans;
        return ans;
    }

    public static void main(String[] strings) {
        String one = "abcd";
        String two = "abcxd";

        sol = new Integer[one.length()][two.length()];
        int ans = findLis(one, two, one.length() - 1, two.length() - 1);
        System.out.println(ans);

        Stack<Character> characters = new Stack<Character>();
        int x = one.length()-1;
        int y = two.length()-1;
        while(x >= 0 && y >=0){

            if(x-1 >= 0 && sol[x][y] == sol[x-1][y]){
                x--;
            }else if(y-1 > 0 && sol[x][y] == sol[x][y-1]){
                y--;
            }else{
                characters.push(one.charAt(x));
                x--;y--;
            }
        }
        while(!characters.empty()){
            System.out.print(characters.pop()+" ");
        }
    }

}
