package dsAlgo.medium.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an integer, rooms, which represents the total number of rooms, where each room is numbered from 0 to rooms - 1.
 * Additionally, you are given a 2D2D integer array called meetings, where each element meetings[i] = [starti,endi][starti​,endi​]
 * indicates that a meeting will be held in the half-closed interval [starti,endi)[starti​,endi​). Each startistarti​​ is unique.
 * <p>
 * Meetings are allocated to rooms in the following manner:
 * <p>
 * Each meeting will take place in the unused room with the lowest number.
 * <p>
 * If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
 * <p>
 * When a room is vacated, the meeting with the earliest original start time is given priority for that room.
 * <p>
 * Your task is to determine the room number that hosted the most meetings. If there are multiple rooms, return the room with the lowest number.
 * <p>
 * Note: A half-closed interval [a, b) is the interval between a and b, including a and not including b.
 * <p>
 * Constraints:
 * <p>
 * 1≤1≤ rooms ≤100≤100
 * <p>
 * 1≤1≤ meetings.length ≤1000≤1000
 * <p>
 * meetings[i].length == 22
 * <p>
 * 0≤starti<endi≤100000≤starti​<endi​≤10000
 */
public class MeetingRooms {

    static class Meeting {
        int room;
        int endTime;

        public Meeting(int room, int endTime) {
            this.room = room;
            this.endTime = endTime;
        }
    }



    public static int mostBooked(int[][] meetings, int rooms) {
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        int[] roomCount = new int[rooms];
        for (int i = 0; i < rooms; i++) {
            availableRooms.add(i);
        }
        PriorityQueue<Meeting> runningMeetings = new PriorityQueue<>(
                (a, b) -> a.endTime != b.endTime ? Integer.compare(a.endTime, b.endTime) : Integer.compare(a.room, b.room)
        );
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] meeting : meetings) {
            while (!runningMeetings.isEmpty() && runningMeetings.peek().endTime <= meeting[0]) {
                availableRooms.add(runningMeetings.poll().room);
            }
            Integer room = availableRooms.poll();
            if (room != null) {
                roomCount[room] = roomCount[room] + 1;
                runningMeetings.add(new Meeting(room, meeting[1]));
            } else {
                //find earliest meeting to end, if multiple have same ending time end all
                Meeting endingMeeting = runningMeetings.poll();
                room = endingMeeting.room;
                int newStartTime = endingMeeting.endTime;
                int newEndTime = newStartTime + (meeting[1] - meeting[0]);
                roomCount[room] = roomCount[room] + 1;
                runningMeetings.add(new Meeting(room, newEndTime));
            }
        }
        int room = 0;
        for(int x = 1; x< roomCount.length;x++){
            if(roomCount[room] < roomCount[x]){
                room = x;
            }
        }
        return room;
    }

    public static void main(String[] args) {

        int[][][] meetings = {
                {{0, 10}, {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}},
                {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}},
                {{1, 2}, {0, 10}, {2, 3}, {3, 4}},
                {{0, 2}, {1, 2}, {3, 4}, {2, 4}},
                {{1, 9}, {2, 8}, {3, 7}, {4, 6}, {5, 11}}
        };

        int[] rooms = {3, 3, 2, 4, 3};

        for (int i = 0; i < meetings.length; i++) {
            System.out.println((i + 1) + ".\tMeetings: " + Arrays.deepToString(meetings[i]));
            System.out.println("\tRooms: " + rooms[i]);
            int bookedRoom = mostBooked(meetings[i], rooms[i]);
            System.out.println("\tRoom that held the most meetings: " + bookedRoom);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
