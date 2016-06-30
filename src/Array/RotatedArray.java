package Array;

/**
 * Created by dheeraj on 6/30/2016.
 */
public class RotatedArray {

    private static int findRotated(int[] ints, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (ints[mid] > ints[mid+1] && ints[mid] > ints[mid-1]){
            return mid;
        }else if(ints[mid] < ints[end]){
             return findRotated(ints,start,mid-1);
        }else{
             return findRotated(ints,mid+1,end);
        }
    }

    public static void main(String[] strings){
        int[] ints = new int[]{8,9,1,2,3,4,5,6,7};
        System.out.println(findRotated(ints,0,ints.length-1)+1);
    }

}
