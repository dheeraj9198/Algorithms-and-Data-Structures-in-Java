package DP;

/**
 * Created by dheeraj on 8/7/16.
 */
public class LongestPalindromeSubstring {
    private static Boolean[][] booleenMat;
    private static int startA = 0, endA = 0;

    private static boolean findLPS(String s, int start, int end) {
        if (booleenMat[start][end] != null) {
            return booleenMat[start][end];
        }
        boolean ans = false;
        if (start == end) {
            ans = true;
        } else if ((start + 1 == end) && s.charAt(start) == s.charAt(end)) {
            ans = true;
        } else {
            boolean b = findLPS(s, start + 1, end - 1);
            if (s.charAt(start) == s.charAt(end)) {
                ans = b;
            }
        }
        booleenMat[start][end] = ans;
        if (ans && end - start > endA - startA) {
            endA = end;
            startA = start;
        }
        return ans;
    }

    public static void main(String[] strings) {
        String s = "forgeeksskeegfor";
/*
        String s = "abadaba";
*/
        booleenMat = new Boolean[s.length()][s.length()];
        findLPS(s, 0, s.length() - 1);
        System.out.println(s.substring(startA, endA + 1));
    }
}
