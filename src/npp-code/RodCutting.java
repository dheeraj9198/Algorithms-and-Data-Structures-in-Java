/**
 * the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * ____________________________________________________________________________________________________________________
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */

class RodCutting {

    static int[] price;
    static int[] solution;
    static int[] firstCut;

    static int cut(int length) {
        if (solution[length] != -1) {
            return solution[length];
        }
        int sol = price[length];//uncut price
        for (int k = 1; k < length; k++) {
            int sol1 = price[k] + cut(length - k);
            if (sol1 > sol) {
                sol = sol1;
                firstCut[length] = k;
            }
        }
        solution[length] = sol;
        return sol;
    }

    public static void main(String[] s) {

        price = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20};
        solution = new int[9];
        firstCut = new int[9];

        for (int x = 0; x < solution.length; x++) {
            solution[x] = -1;
        }
        solution[0] = 0;
        solution[1] = 1;

        System.out.println(cut(8));
        for (int k =0;k<solution.length;k++){
            System.out.println(k + "*"+solution[k]+"*"+firstCut[k]);
        }

    }


}
