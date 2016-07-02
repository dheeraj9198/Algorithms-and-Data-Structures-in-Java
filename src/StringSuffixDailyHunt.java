import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Aurus on 6/14/2016.
 * Rob needs to give a string to each of his students. There is huge string S that is known to all. He doesn't want to work much, hence decides to give each of them, some prefix of S.

 Now, the students consider their strings holy, if their string is very similar to this known string S. Now, this similarity comparison is done from suffix matching.

 So, now you are to help in this computation. So, given an integer i, find the longest matching suffix in between the two strings : S[0...i-1] and S.

 Input:
 The first line contains string S. The next line contains q, the number of queries. Each of the following q lines contain a number i, denoting the query.

 Output:
 Output q lines each containing the answer as explained above.

 Constraints:
 1 <= |S| <= 200000
 1 <= q <= |S|
 1 <= i <= |S|

 Sample Input(Plaintext Link)
 ababa
 5
 1
 2
 3
 4
 5
 */
public class StringSuffixDailyHunt {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int length = string.length();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int sublength = Integer.parseInt(br.readLine());
            int countRun = 0;
            while (countRun < sublength) {
                if (string.charAt(length - 1 - countRun) == string.charAt(sublength -1 - countRun)) {
                }else{
                    break;
                }
                countRun++;
            }
            System.out.println(countRun);
        }
    }
}
