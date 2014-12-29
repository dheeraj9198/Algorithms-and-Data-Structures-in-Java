package Backtracking;

import java.util.ArrayList;

/**
 * Created by dheeraj on 28/12/14.
 */
public class TugOfWar {
    private int[] players;
    private int length;
    private int lengthA;
    private int lengthB;

    private ArrayList<Integer> setA;
    private ArrayList<Integer> setB;

    int diff = Integer.MAX_VALUE;

    private TugOfWar(int[] arr){
        players = arr;
        length = players.length;
        lengthA = length/2;
        lengthB = length - length/2;

        setA = new ArrayList<Integer>();
        setB = new ArrayList<Integer>();
    }

    private ArrayList<Integer> copyArray(ArrayList<Integer> arr,Integer next){
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(Integer integer : arr){
            copy.add(integer);
        }
        if(next != null)
        {
            copy.add(next);
        }
        return copy;
    }



    private int findSum(ArrayList<Integer> arr){
        int sum = 0;
        for(Integer integer : arr){
            sum = sum+integer;
        }
        return sum;
    }

    private void solve(ArrayList<Integer> A,ArrayList<Integer> B,int index){
        if(A.size() == lengthA){
            for(int x = index;x<length;x++){
                    B.add(players[x]);
            }
            int t = Math.abs(findSum(A) - findSum(B));
            if(t < diff){
                setB = B;
                setA = A;
                diff = t;
            }
            return;
        }

        if(B.size() == lengthB){
            for(int x = index;x<length;x++){
                    A.add(players[x]);
            }
            int t = Math.abs(findSum(A) - findSum(B));
            if(t < diff){
                setB = B;
                setA = A;
                diff = t;
            }
            return;
        }

        solve(copyArray(A,players[index]),copyArray(B,null),index+1);
        solve(copyArray(A,null),copyArray(B,players[index]),index+1);
    }

    public static void main(String[] args){
        int[] arr = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        TugOfWar tugOfWar = new TugOfWar(arr);
        tugOfWar.solve(new ArrayList<Integer>(),new ArrayList<Integer>(),0);
        System.out.println(tugOfWar.setA);
        System.out.println(tugOfWar.setB);
    }

}
