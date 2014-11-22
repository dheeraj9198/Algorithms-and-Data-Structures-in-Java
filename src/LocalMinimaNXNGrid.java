/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/22/14
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocalMinimaNXNGrid {
    // NxN matrix
    private static int martix[][] = new int[][]{
            {20, 100, 12, 11},
            {19, 100, 13, 100},
            {18, 100, 14, 100},
            {17, 16, 15, 100}
    };
    private static boolean minimaFound = false;
    private static int minima;

    public static void main(String[] args) {
        findMinimaInCol(martix.length / 2, 0, martix.length);
        if(minimaFound)
        {
            System.out.println("Minima = "+minima);
        }else{
            System.out.println("No minima found");
        }
    }

    public static void findMinimaInRow(int y, int minx, int maxx) {
        for (int i = minx; i < maxx; i++) {
            if (isMin(i, y)) {
                minimaFound = true;
                minima = martix[i][y];
                return;
            } else {
                if (martix[(minx + maxx) / 2][y] < martix[(minx + maxx) / 2][y - 1]) {
                    findMinimaInCol((minx + maxx) / 2, 0, y - 1);
                } else {
                    findMinimaInCol((minx + maxx) / 2, y + 1, martix.length);
                }
            }
        }
    }


    public static void findMinimaInCol(int x, int miny, int maxy) {
        for (int j = miny; j < maxy; j++) {
            if (isMin(x, j)) {
                minimaFound = true;
                minima = martix[x][j];
                return;
            } else {
                if (martix[x][(miny + maxy) / 2] < martix[x - 1][(miny + maxy) / 2]) {
                    findMinimaInRow((miny + maxy) / 2, 0, x - 1);
                } else {
                    findMinimaInRow((miny + maxy) / 2, x + 1, martix.length);
                }
            }
        }
    }

    private static boolean isMin(int x, int y) {
        int num = martix[x][y];
        for (int i = Math.max(0, x - 1); i < Math.min(x + 2, martix.length); i++) {
            for (int j = Math.max(0, y - 1); j < Math.min(y + 2, martix.length); j++) {
                if (martix[i][j] > num) {
                    return false;
                }
            }
        }
        return true;
    }
}
