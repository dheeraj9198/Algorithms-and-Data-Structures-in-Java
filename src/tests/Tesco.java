package tests;

import java.util.ArrayList;

/**
 * Created by dheeraj on 6/30/2016.
 */
public class Tesco {
    public static void main(String[] s) throws Exception {

        //cloth visiblity question   wire length,cloth count,cloth start-end
        /*System.out.println(new Test().GetVisibleCount(10, 5, new int[][]{{0, 4}, {6, 3}, {1, 5}, {6, 4}, {7, 2}}));
*/
        //min length substring that contains all the chars
        System.out.print(new Tesco().GetSubString("My Name is Fran","rim"));
    }

    public int GetVisibleCount(int input1, int input2, int[][] input3) {
        ArrayList<int[]> visibleArrayList = new ArrayList<int[]>();
        for (int x = 0; x < input2; x++) {
            int[] current = input3[x];
            for (int[] currentVisible : visibleArrayList) {
                if (currentVisible[0] >= current[0] && (currentVisible[0] + currentVisible[1] <= current[0] + current[1])) {
                    visibleArrayList.remove(currentVisible);
                }
            }
            visibleArrayList.add(current);
        }
        return visibleArrayList.size();
    }

    public String GetSubString(String input1, String input2) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int k = 0; k < input1.length(); k++) {
            for (int l = k + 1; l < input1.length(); l++) {
                if (l - k < input2.length()) {
                    continue;
                }
                boolean allFound = true;
                for (int c = 0; c < input2.length(); c++) {
                    boolean found = false;
                    for (int x = k; x <= l; x++) {
                        if (input2.charAt(c) == input1.charAt(x)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        allFound = false;
                        break;
                    }
                }
                if (allFound) {
                    arrayList.add(new int[]{k,l});
                }
            }
        }
        int[] ints = arrayList.get(0);
        for(int[] ints1 : arrayList){
            if(ints[1] - ints[0] > ints1[1] - ints1[0]){
                ints = ints1;
            }
        }
        return input1.substring(ints[0],ints[1]+1);
    }

}
