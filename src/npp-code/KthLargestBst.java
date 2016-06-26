class KthLargestBst {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int count = 0;


    private static void getKth(Node root, int k) {
        if (root == null) {
            return;
        }
        getKth(root.right, k);
        count++;
        if (count == k) {
            System.out.println(root.data);
            return;
        }
        getKth(root.left, k);
    }


    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);

        getKth(root, 1);

    }


}