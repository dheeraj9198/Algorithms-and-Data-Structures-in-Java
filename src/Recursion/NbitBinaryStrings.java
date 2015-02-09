package Recursion;

/**
 * Created by dheeraj on 10/2/15.
 */
public class NbitBinaryStrings {

    private static char[] array;

    public static void main(String[] args) {
        int n = 3;
        array = new char[n];
        binaryString(n);
    }

    public static void binaryString(int n) {
        if (n == 0) {
            System.out.println(array);
        } else {
            array[n - 1] = '0';
            binaryString(n - 1);
            array[n - 1] = '1';
            binaryString(n - 1);
        }
    }
}
