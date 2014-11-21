package ProblemSolving;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Aurus
 * Date: 11/19/14
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
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
