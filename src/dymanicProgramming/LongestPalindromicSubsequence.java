package dymanicProgramming;

/**
 * Created by dheeraj on 8/7/16.
 */
public class LongestPalindromicSubsequence {
    //BBABCBCAB”, then the output should be 7 as “BABCBAB
    private static Integer[][] ints;
    private static int startA, endA;
    private static int len = 0;

    private static int findLPS(String s, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (ints[start][end] != null) {
            return ints[start][end];
        }

        int length = 1;
        if (start == end) {
            length = 1;
        } else if (start + 1 == end && s.charAt(start) == s.charAt(end)) {
            length = 2;
        } else {
            int a = findLPS(s, start + 1, end - 1);
            int b = findLPS(s, start + 1, end);
            int c = findLPS(s, start, end - 1);

            if (s.charAt(start) == s.charAt(end)) {
                length = a + 2;
            } else {
                length = b > c ? b : c;
            }
        }
        ints[start][end] = length;
        if (length > len) {
            len = length;
            startA = start;
            endA = end;
        }
        return length;
    }

    private static String printSeq(String string, int s, int e) {
        if (s == e) {
            return string.charAt(s) + "";
        }
        if (ints[s + 1][e] == ints[s][e]) {
            return printSeq(string, s + 1, e);
        } else if (ints[s][e - 1] == ints[s][e]) {
            return printSeq(string, s, e - 1);
        } else {
            return string.charAt(s) + printSeq(string, s + 1, e - 1) + string.charAt(e);
        }
    }

    public static void main(String[] strings) {
        // abab
        /*
          0 1 2 3
        0 1 1 3 3
        1   1 1 3
        2     1 1
        3       1
        */
/*
        String s = "BBABCBCAB";
*/
/*
        String s = "GEEKSFORGEEKS";
*/
        String s = "agbdba";

        ints = new Integer[s.length()][s.length()];

        findLPS(s, 0, s.length() - 1);
        System.out.println(len);
        System.out.print(printSeq(s, startA, endA));
    }
}
