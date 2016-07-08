package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/10/14
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Heap {

    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int temp;
        while (true) {
            line = bufferedReader.readLine();
            if (line.equals("exit")) {
                break;
            } else if (line.equals("print")) {
                //print min element
                if (minHeap.size() > 0) {
                    System.out.println("minimum element is " + minHeap.peek());
                }
            } else {
                try {
                    temp = Integer.parseInt(line);
                    minHeap.add(temp);
                } catch (Exception e) {

                }
            }
        }


    }

}
