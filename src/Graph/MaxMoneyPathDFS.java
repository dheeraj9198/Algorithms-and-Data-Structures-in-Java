package Graph;/*
An MxN grid: for each grid point, there is a certain amount of money on it.

A person: top-left corner => bottom-right corner. Moves right or down.

Optimal path? collect the maximum sum of money.

O(n^2)

//where i have to run it
   0  1 2
 0 5 10 8
 1 2 12 14

*/

import java.util.LinkedList;

public class MaxMoneyPathDFS {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static int maxSum = Integer.MIN_VALUE;
    static LinkedList<Node> maxSumPath;

    static LinkedList<Node> pathLinkedList = new LinkedList<Node>();

    //provided money matrix
    static int[][] matrix = new int[][]{{5, 10, 8}, {2, 12, 14}};
    static int[][] visited = new int[matrix.length][matrix[0].length];

    public static void main(String[] strings) {
        int x = 0;
        int y = 0;
        Node node = new Node(x, y);
        pathLinkedList.add(node);
        visited[x][y] = 1;
        maxSumCalc(x, y, matrix[x][y]);
        visited[x][y] = 0;
        pathLinkedList.remove(node);
        System.out.print(maxSumPath);
    }


    //actual dfs
    static void maxSumCalc(int x, int y, int sumTillNow) {

        //detect end
        if (x == matrix.length - 1 && y == matrix[0].length - 1) {
            if (sumTillNow > maxSum) {
                maxSum = sumTillNow;
                maxSumPath = copyLinkedList(pathLinkedList);
            }

        }

        //right move
        if (x + 1 < matrix.length) {
            if (visited[x + 1][y] == 0) {
                visited[x + 1][y] = 1;
                Node node = new Node(x + 1, y);
                pathLinkedList.add(node);
                maxSumCalc(x + 1, y, sumTillNow + matrix[x + 1][y]);
                pathLinkedList.remove(node);
                visited[x + 1][y] = 0;
            }

        }

        //down move
        if (y + 1 < matrix[0].length) {
            if (visited[x][y + 1] == 0) {
                visited[x][y + 1] = 1;
                Node node = new Node(x, y + 1);
                pathLinkedList.add(node);
                maxSumCalc(x, y + 1, sumTillNow + matrix[x][y + 1]);
                pathLinkedList.remove(node);
                visited[x][y + 1] = 0;
            }

        }


    }

    static LinkedList<Node> copyLinkedList(LinkedList<Node> nodes) {
        LinkedList<Node> nodes1 = new LinkedList<Node>();
        for (Node node : nodes) {
            nodes1.add(node);
        }
        return nodes1;
    }

}




