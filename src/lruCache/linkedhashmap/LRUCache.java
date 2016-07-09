package lruCache.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dheeraj on 7/8/2016.
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> integerDLLNodeHashMap = new LinkedHashMap<Integer, Integer>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > maxSize;
        }
    };
    private int maxSize;

    public LRUCache(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        return integerDLLNodeHashMap.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        integerDLLNodeHashMap.put(key, value);
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
