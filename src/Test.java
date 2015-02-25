import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by dheeraj on 18/2/15.
 */
public class Test {
    public static final class Data implements Comparable<Data>{
        private int number;
        public Data(int x){
            this.number = x;
        }
        @Override
        public int compareTo(Data o) {
            if(this.number > o.number)return 1;
            else if(this.number < o.number)return -1;
            else return 0;
        }
    }


    public static void main(String[] args){
        ArrayList<Data> datas = new ArrayList<Data>();

        for(int k = 0;k< 10;k++){
            datas.add(new Data(10-k));
        }

        for(int k = 0;k< 10;k++){
            System.out.print(datas.get(k).number+" ");
        }
        System.out.println();

        Collections.sort(datas);

        for(int k = 0;k< 10;k++){
            System.out.print(datas.get(k).number+" ");
        }
        System.out.println();

    }


}
