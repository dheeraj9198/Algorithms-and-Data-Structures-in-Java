package string;

/**
 * Created by dssachan on 1/28/17.
 */
public class SmallestWindowContainingAllChars {

    /*
    To help illustrate this approach, I use a different example: S = “acbbaca” and T = “aba“.
     The idea is mainly based on the help of two pointers (begin and end position of the window)
     and two tables (needToFind and hasFound) while traversing S. needToFind stores the total count
      of a character in T and hasFound stores the total count of a character met so far. We also use
      a count variable to store the total characters in T that’s met so far (not counting characters
       where hasFound[x] exceeds needToFind[x]). When count equals T‘s length, we know a valid window is found.
    Each time we advance the end pointer (pointing to an element x), we increment hasFound[x] by one.
     We also increment count by one if hasFound[x] is less than or equal to needToFind[x]. Why? When
     the constraint is met (that is, count equals to T‘s size), we immediately advance begin pointer
     as far right as possible while maintaining the constraint.
            How do we check if it is maintaining the constraint? Assume that begin points to an element x,
             we check if hasFound[x] is greater than needToFind[x]. If it is, we can decrement hasFound[x] by
              one and advancing begin pointer without breaking the constraint. On the other hand, if it is not,
              we stop immediately as advancing begin pointer breaks the window constraint.
            Finally, we check if the minimum window length is less than the current minimum. Update the current
             minimum if a new minimum is found.

             My note : add extra boolean hasFoundOnce = false,when is becomes true for first time
             make end = k, then check if main.charAt(begin) == main.charAt(k) then move begin forward
     */


    /*private static final String mainString = "this is a test string";
    private static final String subString = "tist";*/

     private static final String mainString = "acbbaca";
    private static final String subString = "aba";

    public static void main(String[] strings) {
        int[] toBeFound = new int[256];
        for (int k = 0; k < subString.length(); k++) {
            toBeFound[(int) subString.charAt(k)] = toBeFound[(int) subString.charAt(k)] + 1;
        }
        int[] hasFound = new int[256];
        int begin = 0;
        int end = 0;
        boolean hasFoundOnce = false;
        int count = 0;
        for (int k = 0; k < mainString.length(); k++) {
            hasFound[(int) mainString.charAt(k)] = hasFound[(int) mainString.charAt(k)] + 1;
            if (hasFound[(int) mainString.charAt(k)] <= toBeFound[(int) mainString.charAt(k)]) {
                count++;
            }
            if (count == subString.length() && !hasFoundOnce) {
                hasFoundOnce = true;
                end = k;
                //remove useless from start
                while (true) {
                    if (hasFound[(int) mainString.charAt(begin)] > toBeFound[(int) mainString.charAt(begin)]) {
                        hasFound[(int) mainString.charAt(begin)] = hasFound[(int) mainString.charAt(begin)] - 1;
                        begin++;
                    } else {
                        break;
                    }
                }
            } else if (hasFoundOnce && mainString.charAt(k) == mainString.charAt(begin)) {
                end = k;
                //remove useless from start
                while (true) {
                    if (hasFound[(int) mainString.charAt(begin)] > toBeFound[(int) mainString.charAt(begin)]) {
                        hasFound[(int) mainString.charAt(begin)] = hasFound[(int) mainString.charAt(begin)] - 1;
                        begin++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(mainString.substring(begin, end + 1));
    }


}