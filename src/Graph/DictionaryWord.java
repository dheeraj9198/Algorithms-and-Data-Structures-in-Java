package Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a 2-dimensional array of characters and a
 * dictionary in which a word can be searched in O(1) time.
 * Need to print all the words from array which are present
 * in dictionary. Word can be formed in any direction but
 * has to end at any edge of array.
 * (Need not worry much about the dictionary)
 */
public class DictionaryWord {
    private static char[][] matrix = new char[][]{
            {'a', 'f', 'h', 'u', 'n'},
            {'e', 't', 'a', 'i', 'r'},
            {'a', 'e', 'g', 'g', 'o'},
            {'t', 'r', 'm', 'l', 'p'}
    };
    private static int dim_x = matrix.length;
    private static int dim_y = matrix[matrix.length -1].length;
    private static Set<String> wordSet = new HashSet<String>();

    public static void main(String[] args) {
        //dictionary
        wordSet.add("after");
        wordSet.add("hate");
        wordSet.add("hair");
        wordSet.add("air");
        wordSet.add("eat");
        wordSet.add("tea");
        int[][] visitedMap = new int[dim_x][dim_y];
        for (int x = 0; x < dim_x; x++) {
            for (int y = 0; y < dim_y; y++) {
                checkAndPrint(matrix[x][y] + "");
                visitedMap[x][y] = 1;
                recursion(matrix[x][y] + "", visitedMap, x, y);
                visitedMap[x][y] = 0;
            }
        }
    }

    private static void checkAndPrint(String word) {
        if (wordSet.contains(word)) {
            System.out.println(word);
        }
    }

    private static void recursion(String word, int[][] visitedMap, int x, int y) {
        for (int i = Math.max(x - 1, 0); i < Math.min(x + 2, dim_x); i++) {
            for (int j = Math.max(y - 1, 0); j < Math.min(y + 2, dim_y); j++) {
                if (visitedMap[i][j] != 1) {
                    visitedMap[i][j] = 1;
                    checkAndPrint(word + matrix[i][j]);
                    recursion(word + matrix[i][j], visitedMap, i, j);
                    visitedMap[i][j] = 0;
                }
            }
        }
    }

}
