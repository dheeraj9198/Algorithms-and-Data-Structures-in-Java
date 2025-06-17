package dsAlgo.medium.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * We are given an array of closed intervals called intervals, where each interval has a start time and an end time and is represented as intervals[i] = [starti, endi].
 * Your task is to merge the overlapping intervals and return a new output array consisting of only the non-overlapping intervals.
 * Constraints:
 *     1≤1≤ intervals.length ≤103≤103
 *     intervals[i].length ==2==2
 *     0≤0≤ starti ≤≤ endi ≤104≤104
 */
public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(intervals[0]);
        for(int x=1;x<intervals.length;x++){
            if(arrayList.get(arrayList.size()-1)[1] >= intervals[x][0]){
                //use max of intervals in comparison
                arrayList.get(arrayList.size()-1)[1] = Math.max(intervals[x][1],arrayList.get(arrayList.size()-1)[1]);
            }else {
                arrayList.add(intervals[x]);
            }
        }
        return arrayList.toArray(new int[arrayList.size()][2]);
    }

    public static void main(String[] args) {

        int[][][] all_intervals = {
                {{3, 7}, {1, 5}, {4, 6}},
                {{1, 5}, {6, 8}, {4, 6}, {11, 15}},
                {{3, 7}, {10, 12}, {6, 8}, {11, 15}},
                {{1, 5}},
                {{1, 9}, {4, 4}, {3, 8}},
                {{1, 2}, {8, 8}, {3, 4}},
                {{1, 5}, {1, 3}},
                {{1, 5}, {6, 9}},
                {{0, 0}, {1, 18}, {1, 3}}
        };

        for (int i = 0; i < all_intervals.length; i++) {
            System.out.println((i + 1) + ".\tIntervals to merge: " + Arrays.deepToString(all_intervals[i]));
            int[][] result = mergeIntervals(all_intervals[i]);
            System.out.println("\tMerged intervals:\t" + Arrays.deepToString(result));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
