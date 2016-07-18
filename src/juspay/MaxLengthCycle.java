package juspay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by dheeraj on 7/18/2016.
 * find max length cycle
 */
public class MaxLengthCycle {

    private static int length = 0;
    private static HashMap<Integer, ArrayList<Integer>> integerArrayListHashMap = new HashMap<Integer, ArrayList<Integer>>();

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

 /*       line = br.readLine();
        strings = line.split(" ");
        int start = Integer.parseInt(strings[0]);
        int end = Integer.parseInt(strings[1]);*/

        for (int k = 0; k < N; k++) {
            integerArrayListHashMap.put(k, new ArrayList<Integer>());
        }
        for (int k = 0; k < N; k++) {
            integerArrayListHashMap.get(k).add(array[k]);
        }

        LinkedList<Integer> visitedLinkedList = new LinkedList<Integer>();
        for (Integer integer : integerArrayListHashMap.keySet()) {
            visitedLinkedList.add(integer);
            DFS(integer, visitedLinkedList);
            visitedLinkedList.remove(integer);
        }
        System.out.println(length);
    }

    private static void DFS(Integer key, LinkedList<Integer> visitedLinkedList) {
        ArrayList<Integer> integers = integerArrayListHashMap.get(key);
        for (Integer integer : integers) {
            if (integer != -1) {
                if (visitedLinkedList.contains(integer)) {
                    if (visitedLinkedList.get(0) == integer && visitedLinkedList.size() > length) {
                        length = visitedLinkedList.size();
                    }
                } else {
                    visitedLinkedList.add(integer);
                    DFS(integer, visitedLinkedList);
                    visitedLinkedList.remove(integer);
                }
            }
        }
    }
}
