package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 21/1/15.
 */
public class UniquePermutation {

    public static List<List<Integer>> permuteUnique(int[] num) {
        if (num.length == 2) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            List<Integer> integers = new ArrayList<Integer>();
            integers.add(num[0]);
            integers.add(num[1]);

            result.add(integers);

            List<Integer> integers1 = new ArrayList<Integer>();
            integers1.add(num[1]);
            integers1.add(num[0]);

            if(!exists(result,integers1)){
                result.add(integers1);
            }
            return result;
        }else{
            int[] test = new int[num.length-1];
            for(int o = 0; o<num.length-1;o++){
                test[o] = num[o];
            }

            /*System.out.println("dheeraj");
            for(int l = 0; l<test.length;l++){
                System.out.print(test[l]+" ");
            }
            System.out.println();*/

            List<List<Integer>> data= permuteUnique(test);

          /*  System.out.println("-----------------------------------");
            for(List<Integer> integers : data){
                System.out.println(integers);
            }
            System.out.println("-----------------------------------");*/

            List<List<Integer>> newList = new ArrayList<List<Integer>>();


            for(List<Integer> integers : data){
                for(int k=0;k<=integers.size();k++){
                    List<Integer> abc = new ArrayList<Integer>();
                    for(Integer integer : integers){
                        abc.add(integer);
                    }
                    int dh = num[num.length-1];
                    abc.add(k,dh);

                    boolean contains = false;
                    for(List<Integer> integers1 : newList){
                        if(integers1.equals(abc)){
                            contains = true;
                            break;
                        }
                    }
                    if(!contains){
                        newList.add(abc);
                    }
                }
            }
            return newList;

        }
    }

    private static boolean exists(List<List<Integer>> test,List<Integer> data){
            for(List<Integer> a : test){
                if(a.equals(data)){
                    return true;
                }
            }
        return false;
    }

    public static void main(String[] args){
        int[] data = {1,2,3};
        List<List<Integer>> lists = permuteUnique(data);
        for(List<Integer> integers : lists){
            System.out.println(integers);
        }
    }
}
