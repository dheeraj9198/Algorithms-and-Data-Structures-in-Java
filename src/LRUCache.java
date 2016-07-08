import java.util.HashMap;

/**
 * Created by dheeraj on 7/8/2016.
 */
public class LRUCache {

    private static DLLNode startDllNode, endDllNode;

    private static int maxSize = 3;
    private static int size = 0;

    private static class DLLNode {
        int data, value;
        DLLNode prev, next;

        public DLLNode(int data, int value) {
            this.data = data;
            this.value = value;
        }
    }

    private static HashMap<Integer, DLLNode> integerDLLNodeHashMap = new HashMap<Integer, DLLNode>();

    private static void addData(int key, int value) {
        DLLNode dllNode = new DLLNode(key, value);
        integerDLLNodeHashMap.put(key, dllNode);
        if (size == 0) {
            startDllNode = dllNode;
            endDllNode = dllNode;
            size++;
        } else if (size < maxSize) {
            dllNode.next = startDllNode;
            startDllNode.prev = dllNode;
            startDllNode = dllNode;
            size++;
        } else {
            dllNode.next = startDllNode;
            startDllNode.prev = dllNode;
            startDllNode = dllNode;

            DLLNode end = endDllNode;
            end.next = null;
            DLLNode prevEnd = end.prev;
            end.prev = null;
            prevEnd.next = null;
            endDllNode = prevEnd;
            integerDLLNodeHashMap.remove(end.data);
        }
    }

    private static int getData(int key) {
        DLLNode dllNode = integerDLLNodeHashMap.get(key);
        if (dllNode == null) {
            return -1;
        } else {
            if (dllNode == endDllNode) {
                endDllNode = endDllNode.prev;
            }
            if (dllNode.prev != null) {
                dllNode.prev.next = dllNode.next;
            }
            if (dllNode.next != null) {
                dllNode.next.prev = dllNode.prev;
            }
            dllNode.prev = null;
            dllNode.next = startDllNode;
            startDllNode.prev = dllNode;
            startDllNode = dllNode;
            return dllNode.data;
        }
    }


    public static void main(String[] strings) {
        addData(1, 1);
        addData(2, 2);
        addData(3, 3);

        getData(2);

        addData(4, 4);
        System.out.println();
    }


}
