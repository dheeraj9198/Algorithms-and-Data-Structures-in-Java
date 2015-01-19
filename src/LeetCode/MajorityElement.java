package LeetCode;

/**
 * Created by dheeraj on 20/1/15.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int x =0;
        int elem = 0;

        for(int k =0;k<num.length;k++){
            if(x == 0){
                elem = num[k];
                x++;
            }else{
                if(num[k] == elem){
                    x++;
                }else{
                    x--;
                }
            }
        }
        return elem;
    }
}
