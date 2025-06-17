package dsAlgo.medium.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *

 Given a sorted list of nonoverlapping intervals and a new interval, your task is to insert the new interval into the correct position while ensuring that the resulting list of intervals remains sorted and nonoverlapping. Each interval is a pair of nonnegative numbers, the first being the start time and the second being the end time of the interval.

 Constraints:

 0≤0≤ existing_intervals.length ≤104≤104

 existing_intervals[i].length, new_interval.length == 2

 0≤0≤ start time << end time ≤104≤104

 The list of intervals is sorted in ascending order based on the start timestart time.

//TODO : optimize complexity, it timed out after 5 seconds in main run of educative.io
 */
public class InsertInterval {

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        //no need to sort of the list is sorted
        //Arrays.sort(existingIntervals, (o1, o2) -> o1[0] - o2[0]);
        int index = findIndex(existingIntervals, newInterval);
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < existingIntervals.length; i++) {
            arrayList.add(existingIntervals[i]);
        }
        arrayList.add(index, newInterval);
        return mergeSortedIntervals(arrayList);
    }

    public static int findIndex(int[][] existingIntervals, int[] interval) {
        if (interval[0] < existingIntervals[0][0]) {
            return 0;
        }
        if (interval[0] > existingIntervals[existingIntervals.length - 1][0]) {
            return existingIntervals.length;
        }
        int start = 0;
        int end = existingIntervals.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (existingIntervals[mid][0] < interval[0] && interval[0] < existingIntervals[mid + 1][0]) {
                return mid+1;
            } else if (existingIntervals[mid][0] < interval[0]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return 0;
    }

    public static int[][] mergeSortedIntervals(ArrayList<int[]> intervals) {
        List<int[]> arrayList = new ArrayList<>();
        arrayList.add(intervals.get(0));
        for(int x=1;x<intervals.size();x++){
            if(arrayList.get(arrayList.size()-1)[1] >= intervals.get(x)[0]){
                //use max of intervals in comparison
                arrayList.get(arrayList.size()-1)[1] = Math.max(intervals.get(x)[1],arrayList.get(arrayList.size()-1)[1]);
            }else {
                arrayList.add(intervals.get(x));
            }
        }
        return arrayList.toArray(new int[arrayList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] newIntervals = {
                {5, 7},
                {8, 9},
                {10, 12},
                {1, 3},
                {1, 10}
        };

        int[][][] existingIntervals = {
                {{1, 2}, {3, 5}, {6, 8}},
                {{1, 3}, {5, 7}, {10, 12}},
                {{8, 10}, {12, 15}},
                {{5, 7}, {8, 9}},
                {{3, 5}}
        };

        for (int i = 0; i < newIntervals.length; i++) {
            System.out.print((i + 1) + ".\tExisting intervals: ");
            System.out.println(Arrays.deepToString(existingIntervals[i]));
            System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
            int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
            System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
