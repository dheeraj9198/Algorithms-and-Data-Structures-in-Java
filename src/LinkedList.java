import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/9/14
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
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
        } else {
            root.next = insertData(root.next, data);
        }
        return root;
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
