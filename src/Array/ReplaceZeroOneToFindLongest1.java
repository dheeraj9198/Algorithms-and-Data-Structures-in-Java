package Array;

/**
 * Created by dheeraj on 7/11/2016.
 */
public class ReplaceZeroOneToFindLongest1 {
    public static void main(String[] strings) {
/*
        int[] array = new int[]{1, 0, 1, 1, 0,1, 0, 1, 1, 1, 0, 0};
*/
        int[] array = new int[]{1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1};
        //other way
        //1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1
        //1, 2, 3, 4, 0,1, 2, 3, 4, 5, 6, 7
        //4, 4, 4, 4, 0,7, 7, 7, 7, 7, 7, 7

        int index = -1;
        int maxlen = 0;

        int prevp = -1;
        Integer prevprev0 = null;

        for (int x = 0; x < array.length; x++) {
            if (array[x] == 0) {
                if (prevp == -1) {
                        prevp = x;
                    index = x;
                }else{
                    if(prevprev0 == null){
                        //only one zero found till now
                        if(x > maxlen){
                            index = prevp;
                            maxlen = x;
                        }
                    }else if(x-prevprev0-1 > maxlen){
                        //prev prev 0 excluded
                        index = prevp;
                        maxlen = x-prevprev0-1;
                    }
                    prevprev0 = prevp;
                    prevp = x;
                }

            }
        }

        //check if last is 1
        if(array[array.length-1] == 1 && prevprev0 != null){
            if((array.length-1)-prevprev0 > maxlen){
                index = prevp;
            }
        }
        if(prevprev0 == null && prevp == -1){
            System.out.print(-1);
        }else{
            System.out.println(index);
        }

    }
}
