package reloaded2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by dheeraj on 10/6/16.
 */
public class Hierarchy {
    private static class HeadTail {
        private String head, tail;

        public HeadTail(String head, String tail) {
            this.head = head;
            this.tail = tail;
        }

        public String getHead() {
            return head;
        }

        public String getTail() {
            return tail;
        }
    }

    private static HashMap<String, Boolean> visitedHashMap = new HashMap<String, Boolean>();

    private static HashMap<String, ArrayList<String>> createGraph(List<HeadTail> headTails) {
        HashMap<String, ArrayList<String>> stringArrayListHashMap = new HashMap<String, ArrayList<String>>();
        for (HeadTail headTail : headTails) {
            visitedHashMap.put(headTail.getHead(), false);
            visitedHashMap.put(headTail.getTail(), false);
            if (stringArrayListHashMap.containsKey(headTail.getHead())) {
                stringArrayListHashMap.get(headTail.getHead()).add(headTail.getTail());
            } else {
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(headTail.getTail());
                stringArrayListHashMap.put(headTail.getHead(), strings);
            }

            if (!stringArrayListHashMap.containsKey(headTail.getTail())) {
                stringArrayListHashMap.put(headTail.getTail(), new ArrayList<String>());
            }
        }
        return stringArrayListHashMap;
    }

    private static List<HeadTail> getHeadTails() {
        ArrayList<HeadTail> headTails = new ArrayList<HeadTail>();
        headTails.add(new HeadTail("Naveen", "Satish"));
        headTails.add(new HeadTail("Satish", "Anushree"));
        headTails.add(new HeadTail("Satish", "Sandeep"));
        headTails.add(new HeadTail("Gurinder", "Naveen"));
        headTails.add(new HeadTail("Dheeraj", "Gurinder"));
        headTails.add(new HeadTail("Dheeraj", "Gurinder1"));
        headTails.add(new HeadTail("Gurinder1", "Chutiya"));
        return headTails;
    }

    private static void topSort(Stack<String> stack, HashMap<String, ArrayList<String>> map, String head) {
        if (!visitedHashMap.get(head)) {
            visitedHashMap.put(head, true);
            for (String s : map.get(head)) {
                topSort(stack, map, s);
            }
            stack.push(head);
        }
    }

    public static void main(String[] strings) {
        HashMap<String, ArrayList<String>> stringArrayListHashMap = createGraph(getHeadTails());
        System.out.println(stringArrayListHashMap);
        Stack<String> strings1 = new Stack<String>();
        for (String s : stringArrayListHashMap.keySet()) {
            if (!visitedHashMap.get(s)) {
                topSort(strings1, stringArrayListHashMap, s);
            }
        }
        while (!strings1.isEmpty()) {
            System.out.print(strings1.pop() + ">");
        }
    }

}
