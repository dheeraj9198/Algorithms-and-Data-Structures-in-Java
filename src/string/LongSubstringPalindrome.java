package string;

public class LongSubstringPalindrome {

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] strings) {
        String s = "forgeeksskeegfor";
        String ans = "";
        for (int x = 0; x < s.length(); x++) {
            for (int y = 0; y < s.length(); y++) {
                if (isPalindrome(s, x, y)) {
                    if (ans.length() < y - x + 1) {
                        ans = s.substring(x, y + 1);
                    }
                }
            }
        }
        System.out.println(ans);

    }

}