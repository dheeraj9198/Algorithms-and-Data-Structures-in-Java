import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/11/14
 * Time: 12:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomMinPriorityQueue {

    public static class Vertex {
        int number;
        int distance;

        public Vertex(int num,int dis){
            number = num;
            distance = dis;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Vertex) {
                Vertex vertex = (Vertex) obj;
                return number == vertex.number;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return number*997+distance;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>(10,new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                //min heap
                return o1.distance - o2.distance;
            }
        });

        minHeap.add(new Vertex(1,10));
        minHeap.add(new Vertex(2,9));
        minHeap.add(new Vertex(3,90));

        minHeap.remove(new Vertex(1,10));

        while(minHeap.size() > 0){
            System.out.println(minHeap.peek().distance + "-" +minHeap.remove().number);
        }

    }
}
