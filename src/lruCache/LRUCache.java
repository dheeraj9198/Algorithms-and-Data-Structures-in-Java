package lruCache;

import java.util.HashMap;

/**
 * Created by dheeraj on 7/8/2016.
 */
public class LRUCache {
    private static class DLLNode {
        int key, value;
        DLLNode prev, next;

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DLLNode{" +
                    "data=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private HashMap<Integer, DLLNode> integerDLLNodeHashMap = new HashMap<Integer, DLLNode>();
    private DLLNode startDllNode, endDllNode;
    private int maxSize;
    private int size = 0;

    public LRUCache(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        DLLNode dllNode = integerDLLNodeHashMap.get(key);
        if (dllNode == null) {
            return -1;
        } else {
            if (dllNode == startDllNode) {
                return dllNode.value;
            }
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
            return dllNode.value;
        }
    }

    public void set(int key, int value) {
        DLLNode existing = integerDLLNodeHashMap.get(key);
        if (existing != null) {
            existing.value = value;
            get(key);
            return;
        }

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
            integerDLLNodeHashMap.remove(end.value);
        }
    }

    public static void main(String[] strings) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(3, 2);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.set(4, 3);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        System.out.println();
    }


}
