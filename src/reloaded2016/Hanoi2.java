package reloaded2016;

/**
 * Created by dheeraj on 10/6/16.
 * To move n discs from peg A to peg C:
 * move n−1 discs from A to B. This leaves disc #n alone on peg A
 * move disc #n from A to C
 * move n−1 discs from B to C so they sit on disc #n
 */
public class Hanoi2 {

    private static volatile int steps = 0;

    private static void hanoi(int count, String source, String temp, String destination) {
        if (count == 1) {
            steps++;
            System.out.format("transferring % d from %s to %s\n", count, source, destination);
        }else{
            hanoi(count-1,source,destination,temp);
            steps++;
            System.out.format("Moving %d from %s to %s\n",count,source,destination);
            hanoi(count-1,temp,source,destination);
        }
    }

    public static void main(String[] strings) {
        hanoi(4,"source","temp","destination");
        System.out.println("steps taken = "+steps);
    }

}
