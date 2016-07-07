package stringMatching;

/**
 * Created by dheeraj on 6/26/2016.
 */
public class RabinKarp {

    private static int prime = 7;

    private static long getHash(String s,int patLength) {
        long hash = 0;
        for (int k = 0; k < s.length(); k++) {
            int ka = ((int) s.charAt(k));
            long exp = (long) Math.pow((double) prime , (double) (patLength - k - 1));
            long x= ka * exp;
            hash = hash+x;
        }
        return hash;
    }

    private static long getReHash(long hash, String s, int oldIndex, int newIndex, int patLength) {
        char oldChar = s.charAt(oldIndex);
        char newChar = s.charAt(newIndex);
        return (hash * prime) - (((int) oldChar) * (long)Math.pow(prime , patLength)) + ((int) newChar);
    }


    public static void main(String[] strings) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";

       /* String txt = "AAA";
        String pat = "AA";
*/
        String initString = txt.substring(0, pat.length());

        long patHash = getHash(pat,pat.length());
        long hash = getHash(initString,pat.length());

        for (int x = 0; x <= txt.length() - pat.length(); x++) {
            if (hash == patHash) {
                if (initString.equals(pat)) {
                    System.out.println(x);
                }
            }
            if(x + pat.length() < txt.length()) {
                hash = getReHash(hash, txt, x, x + pat.length(), pat.length());
            }
        }
    }

}
