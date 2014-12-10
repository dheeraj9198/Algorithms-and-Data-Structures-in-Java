import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 11/29/14
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<HashSet<Integer>> samecountryList = new ArrayList<HashSet<Integer>>();
        int numberOfAst;
        int samecountryCases;
        String test;

        HashSet<Integer> tempIntegerHashSet = null;

        long permissiblePairs = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        test = bufferedReader.readLine();
        String[] result = test.split(" ");

        numberOfAst = Integer.parseInt(result[0]);
        samecountryCases = Integer.parseInt(result[1]);

        for (int x = 0; x < samecountryCases; x++) {
            test = bufferedReader.readLine();
            result = test.split(" ");

            int key = Integer.parseInt(result[0]);
            int value = Integer.parseInt(result[1]);

            tempIntegerHashSet = null;

            if (x == 0) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                hashSet.add(key);
                hashSet.add(value);
                samecountryList.add(hashSet);
            } else {
                for (HashSet<Integer> i : samecountryList) {
                    if (i.contains(key) || i.contains(value)) {
                        tempIntegerHashSet = i;
                        break;
                    }
                }

                if(tempIntegerHashSet == null)
                {
                    HashSet<Integer> hashSet = new HashSet<Integer>();
                    hashSet.add(key);
                    hashSet.add(value);
                    samecountryList.add(hashSet);
                }else{
                    tempIntegerHashSet.add(key);
                    tempIntegerHashSet.add(value);
                }
            }
        }


       /* for (HashSet<Integer> i : samecountryList) {
           for(Integer k : i)
           {
               System.out.print(k+" ");
           }
            System.out.println();
        }
                                 if(true)return;*/

        for(int x=0;x<numberOfAst;x++)
        {
            for(int y=x+1;y<numberOfAst;y++)
            {
                boolean sameCflag = false;
                for (HashSet<Integer> i : samecountryList) {
                    if(i.contains(x) && i.contains(y))
                    {
                        sameCflag = true;
                        break;
                    }
                }

                if(!sameCflag)
                {
                    permissiblePairs++;
                }
            }
        }

        System.out.println(permissiblePairs);

    }

}
