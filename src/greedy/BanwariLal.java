package greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * banwari lal is a goods trader who buys shit from market and sells it in retail
 * market to earn profit.X money N goods at price p1...pn,sells at s1...sn and
 * he can only sell m1.....mn of each good and hence cannot buy most profitable
 * good only.help him decide what to buy and how much to maximize his profit.
 *
 * input
 * 200 5
 * 90 40 3 18 600
 * 145 55 5 35 700
 * 2 7 5 5 8
 * output
 * 1 0 5 5 0
 */

public class BanwariLal {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String data = bufferedReader.readLine();
        int money;
        int num;
        String[] s = data.split(" ");
        money = Integer.parseInt(s[0]);
        num = Integer.parseInt(s[1]);

        int[] cp = new int[num];
        int[] sp = new int[num];
        int[] quantity = new int[num];

        data = bufferedReader.readLine();
        s = data.split(" ");

        for(int x =0;x<s.length;x++){
            cp[x] = Integer.parseInt(s[x]);
        }

        data = bufferedReader.readLine();
        s = data.split(" ");

        for(int x =0;x<s.length;x++){
            sp[x] = Integer.parseInt(s[x]);
        }

        data = bufferedReader.readLine();
        s = data.split(" ");

        for(int x =0;x<s.length;x++){
            quantity[x] = Integer.parseInt(s[x]);
        }

        TreeMap<Float,Integer> profitIndexMap = new TreeMap<Float,Integer>(new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return -1*o1.compareTo(o2);
            }
        });
        HashMap<Integer,Integer> indexQuanMap = new HashMap<Integer,Integer>();

        for(int x=0;x<s.length;x++){
            profitIndexMap.put((float)((sp[x]-cp[x]))/cp[x],x);
            indexQuanMap.put(x,0);
        }

        for(Map.Entry<Float,Integer> entry : profitIndexMap.entrySet()){
            if(cp[entry.getValue()]*quantity[entry.getValue()] <= money){
                money = money - cp[entry.getValue()]*quantity[entry.getValue()];
                indexQuanMap.put(entry.getValue(),quantity[entry.getValue()]);
            }else {
                int q = money/cp[entry.getValue()];
                if(q > 0) {
                    money = money - q * cp[entry.getValue()];
                    indexQuanMap.put(entry.getValue(), q);
                }
            }
        }

        for(Integer i : indexQuanMap.values()){
            System.out.print(i+" ");
        }


    }

}
