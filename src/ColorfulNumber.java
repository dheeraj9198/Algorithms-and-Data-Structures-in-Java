import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.util.HashSet;
import java.util.Set;

/**
 * Colorful Number:
 * A number can be broken into different sub-sequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a colorful number, since product of every digit of a sub-sequence are different.
 * That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 */
public class ColorfulNumber {
    public static void main(String[] args) throws Exception {
        String numString = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int num = Integer.parseInt(numString);
        int length = numString.length();
        int[] digits = new int[length];
        int index = length - 1;
        Set<Integer> productSet = new HashSet<Integer>();

        while (num > 0) {
            digits[index] = num % 10;
            if(productSet.contains(digits[index]))
            {
                System.out.println("Not a colorful number");
                return;
            }else{
                //System.out.println("Added "+digits[index]+" at "+index);
                productSet.add(digits[index]);
            }
            num = num / 10;
            index--;
        }
        for (int x = 1; x < length; x++) {
            int product = 1;
            for(int i=0;i<x;i++)
            {
                product = product*digits[i];
            }

            for (int y = x; y < length; y++) {
                if(productSet.contains( product * digits[y]))
                {
                    System.out.println("Not a colorful number");
                    //System.out.println("Not a colorful number "+ product * digits[y]+" exists");
                    return;
                }else{
                    //System.out.println("Added "+ product * digits[y]);
                    productSet.add( product * digits[y]);
                }
            }
        }
        System.out.println("Colorful number");
    }
}
