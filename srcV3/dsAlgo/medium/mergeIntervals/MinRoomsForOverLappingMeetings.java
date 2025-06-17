package dsAlgo.medium.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We are given an input array of meeting time intervals, intervals, where each interval
 * has a start time and an end time. Your task is to find the minimum number
 * of meeting rooms required to hold these meetings.
 * <p>
 * An important thing to note here is that the specified end time for each meeting is exclusive.
 * Constraints
 * 1<=1<= intervals.length <=103<=103
 * 00 ≤≤ startistarti​ << endiendi​ ≤≤ 10610
 *
 *
 *
 * ALTERNATE task scheduling in machines
 *
 * We are given an input array, tasks, where tasks[i] =[starti,endi]=[starti​,endi​] represents the start and end times of nn tasks. Our goal is to schedule these tasks on machines given the following criteria:
 *
 *     A machine can execute only one task at a time.
 *
 *     A machine can begin executing a new task immediately after completing the previous one.
 *
 *     An unlimited number of machines are available.
 *
 * Find the minimum number of machines required to complete these nn tasks.
 *
 * Constraints:
 *
 *     n==n== tasks.length
 *
 *     1≤1≤ tasks.length ≤103≤103
 *
 *     0≤0≤ tasksi.start << tasksi.end ≤104≤10
 */
public class MinRoomsForOverLappingMeetings {

    public static int findSets(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        minHeap.add(intervals[0][1]);
        for (int x = 1; x < intervals.length; x++) {
            //if new meeting start is greater than heap ending one, add it in heap as new room is needed
            if (minHeap.peek() > intervals[x][0]) {
                minHeap.add(intervals[x][1]);
            } else {
                //else remove this meeting and add new one
                minHeap.poll();
                minHeap.add(intervals[x][1]);
            }
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][][] scheduleMeetings = {
                {{0, 10}, {2, 10}, {11, 30}},
                {{3, 7}, {2, 12}, {10, 20}, {8, 24}},
                {{1, 9}, {5, 8}, {4, 14}, {3, 10}, {11, 25}},
                {{1, 4}, {3, 8}, {8, 11}, {3, 17}, {9, 15}, {16, 18}},
                {{4, 12}, {5, 11}, {4, 9}, {2, 12}, {9, 22}}
        };

        for (int i = 0; i < scheduleMeetings.length; i++) {
            System.out.println((i + 1) + ".\tScheduled meetings: " + Arrays.deepToString(scheduleMeetings[i]));
            System.out.println("\tRooms required: " + findSets(scheduleMeetings[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
