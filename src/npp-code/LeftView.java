class LeftView {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private static int levelPrinted = -1;

    private static void printLeft(Node node, int level) {
        if (node == null) {
            return;
        }
        if (levelPrinted < level) {
            System.out.println(node.data);
            levelPrinted++;
        }

        if (node.left != null) {
            printLeft(node.left, level + 1);
        }
        if (node.right != null) {
            printLeft(node.right, level + 1);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(3);
        //root.left = new Node(1);
        root.right = new Node(4);

        printLeft(root, 0);


    }


}



