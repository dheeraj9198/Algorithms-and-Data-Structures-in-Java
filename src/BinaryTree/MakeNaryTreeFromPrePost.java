package BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dheeraj on 7/10/2016.
 */
public class MakeNaryTreeFromPrePost {

    static class Node {
        int data;
        ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            children = new ArrayList<Node>();
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    static int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] post = new int[]{3, 4, 2, 6, 5, 9, 8, 7, 1};

    static HashSet<Integer> integerHashSet = new HashSet<>();

    private static Node makeTree(int postStart, int postEnd, int preIndex) {
        if (postEnd < postStart) {
            return null;
        }
        Node node = new Node(pre[preIndex]);
        integerHashSet.add(pre[preIndex]);
        for (int x1 = 0; x1 < pre.length; x1++) {
            if (!integerHashSet.contains(pre[x1])) {

                int postIndex = -1;
                for(int k =postStart;k<=postEnd;k++){
                      if(post[k] == pre[x1]){
                          postIndex = k;
                          break;
                      }
                }
                int ps = -1, pe = -1;
                for (int x = postStart; x <= postIndex; x++) {
                    if (!integerHashSet.contains(post[x])) {
                        if (ps == -1) {
                            ps = x;
                            pe = x;
                        } else {
                            pe = x;
                        }
                    }
                }
                if (pe != -1 && ps != -1) {
                    node.children.add(makeTree(ps, pe, x1));
                }
            }
        }
        return node;
    }


    public static void main(String[] strings) {
        Node node = makeTree(0, pre.length - 1, 0);
        System.out.println();
    }

}
