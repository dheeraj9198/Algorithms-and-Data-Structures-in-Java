package dutchFlago1Segregation;

/**
 * Created by dheeraj on 6/7/16.
 */
public class Seg012 {

    private static void segregateMy(int[] ints) {
        int start = 0;
        int mid =0;
        int end = ints.length - 1;

        while (mid <=end) {
            if(ints[mid] == 0){
                int l = ints[start];
                ints[start] = ints[mid];
                ints[mid]=l;
                start++;
                mid++;
            }else if(ints[mid] == 2){
                int l = ints[end];
                ints[end] = ints[mid];
                ints[mid]=l;
                mid++;
                end--;
            }else{
                mid++;
            }

        }
    }


    public static void main(String[] strings) {
        int[] ints = new int[]{2,2,0,2,1,1};
        segregateMy(ints);
        for (int k : ints) {
            System.out.print(k + " ");
        }
    }
}
