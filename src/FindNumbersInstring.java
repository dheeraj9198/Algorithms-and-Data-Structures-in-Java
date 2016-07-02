import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Aurus on 6/14/2016.
 * You are given a string S. This string S is made up of lower [a-z] and upper [A-Z] case alphabets, digits [0-9], special characters and empty spaces.

 Your task is to find all the numbers in the string S and output them each in a new line.
 For example: Say the given string S is "Dhoni7 notout at183*runs in 145balls&hit15fours&ten6s!" (quotes around the string are only for clarification)
 We have to find all the numbers in this string. They are:
 7
 183
 145
 15
 6

 NOTE: In order to do this, write a function which accepts string S, find the numbers in the string S and store them in an integer array and then return the array. Finally print the array.

 Input:
 First and only line of input will contain a string S.

 Output:
 Your code should have a function which accepts string S and returns the array containing all the numbers in the string. Finally, print the numbers in the array one in each line.

 Constraints:
 1 ≤ length of S ≤ 1000000

 NOTE : While coding kindly try to avoid using Regular Expression

 Sample Input(Plaintext Link)
 Ahello 123,78. !20 pqer12
 Sample Output(Plaintext Link)
 123
 78
 20
 12
 */
public class FindNumbersInstring {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder stringBuilder = null;
        boolean started = false;
        for (int k = 0; k < line.length(); k++) {
            char c = line.charAt(k);
            int i = (int) c;
            if (i >= 48 && i <= 57) {
                if (started) {
                    stringBuilder.append(c);
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(c);
                    started = true;
                }
            } else if (started) {
                started = false;
                System.out.println(stringBuilder.toString());
                stringBuilder = null;
            }
        }
        if(stringBuilder !=null){
            System.out.println(stringBuilder.toString());
        }


    }
}
