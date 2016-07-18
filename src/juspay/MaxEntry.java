package juspay;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dheeraj on 7/18/2016.
 * find exit which has max entry points
 */
public class MaxEntry {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] array = new int[N];
        line = br.readLine();
        String[] strings = line.split(" ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(strings[i]);
            if (x !=  -1) {
                array[x] = array[x] + 1;
            }
        }
        int max = array[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, array[i]);
        }
        System.out.println(max);

    }
}
