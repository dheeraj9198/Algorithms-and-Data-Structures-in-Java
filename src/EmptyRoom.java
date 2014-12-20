import java.util.*;
import java.util.LinkedList;

/**
 * Created by dheeraj on 12/20/14.
 */
public class EmptyRoom {
    private List<Character> roomList = new LinkedList<Character>();
    private List<Character> nonroomList = new LinkedList<Character>();
    String string;
    int numRooms;

    public EmptyRoom(String string, int numRooms) {
        this.string = string;
        this.numRooms = numRooms;
    }


    private void findAnswer() {
        char data;
        for (int x = 0; x < string.length(); x++) {
            data = string.charAt(x);
            if(roomList.contains(data)){
                roomList.remove(roomList.indexOf(data));
            }else if(roomList.size() < numRooms){
                roomList.add(data);
            }else if(nonroomList.contains(data)){
                //do nothig
            }else{
                nonroomList.add(data);
            }
        }
        System.out.println(nonroomList.size());
    }

    public static void main(String[] args){
        EmptyRoom emptyRoom = new EmptyRoom("ABCBCA",1);
        emptyRoom.findAnswer();
    }

}
