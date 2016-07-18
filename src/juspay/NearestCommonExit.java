package juspay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by dheeraj on 7/18/2016.
 * nearest common exit
 */
public class NearestCommonExit {
    private static int[] integerArrayListHashMap;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] array = new int[N];
        line = br.readLine();
        String[] strings = line.split(" ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        line = br.readLine();
        strings = line.split(" ");
        int start1 = Integer.parseInt(strings[0]);
        int start2 = Integer.parseInt(strings[1]);

        integerArrayListHashMap = new int[N];
        for (int k = 0; k < N; k++) {
            integerArrayListHashMap[k] = array[k];
        }

        HashSet<Integer> visited1 = new HashSet<Integer>();
        HashSet<Integer> visited2 = new HashSet<Integer>();

        visited1.add(start1);
        visited2.add(start2);

        while(true){
            boolean v1 = false;
            if(!visited1.contains(integerArrayListHashMap[start1])) {
                start1 = integerArrayListHashMap[start1];
            }else {
                v1 = true;
            }
            boolean v2 = false;
            if(!visited2.contains(integerArrayListHashMap[start2])) {
                start2 = integerArrayListHashMap[start2];
            }else{
                v2 = true;
            }
            if(v1 && v2){
                System.out.print(-1);
                break;
            }

            if(visited1.contains(start2)){
                System.out.print(start2);
                break;
            }else if(visited2.contains(start1)){
                System.out.print(start1);
                break;
            }
            visited1.add(start1);
            visited2.add(start2);

        }


    }
}
