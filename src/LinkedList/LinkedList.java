package LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dheeraj on 7/2/2016.
 */
public class LinkedList {
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                next = null;
            }
        }

        public Node root;

        public LinkedList() {
            this.root = null;
        }

        public void insert(int data) {
            root = insertData(root, data);
        }

        private Node insertData(Node root, int data) {

            if (root == null) {
                root = new Node(data);
                return root;
            } else {
                // list order = 1 2 3 4 5 if insert order is 1 2 3 4 5
                //root.next = insertData(root.next, data);

                // list order is 5 4 3 2 1 if insert order is 1 2 3 4 5
                Node node = new Node(data);
                node.next = root;
                return node;
            }
        }

        public void print() {
            print(root);
        }

        private void print(Node root) {
            if(root == null){
                return;
            }else{
                System.out.println(root.data);
                print(root.next);
            }
        }


        public static void main(String[] args) {
            String data = "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            LinkedList linkedList = new LinkedList();
            while (true) {

                try{
                    data = bufferedReader.readLine();
                }catch (Exception e){
                }
                if (data.equals("p")) {
                    linkedList.print();
                } else {
                    try{
                        linkedList.insert(Integer.parseInt(data));
                    }catch (Exception r){

                    }
                }
            }
        }

}
