package ProblemSolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/10/14
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllPermutationsOfString {

    public static class Permute{
        public String string;

        public Permute(String s){
                            string = s;
        }

        public void printAll()
        {
            List<String> stringList = printAllPermutations(string);
            for(String s : stringList){
                System.out.println(s);
            }
        }

        public List<String> printAllPermutations(String string)
        {
            if(string.length() == 1)
            {
                List<String> stringList = new ArrayList<String>();
                stringList.add(string);
                return  stringList;
            }

            List<String> list = printAllPermutations(string.substring(1,string.length()));
            List<String> stringList =  new ArrayList<String>();
            for(String s : list){
                 stringList.add(string.charAt(0)+s);
                 stringList.add(s+string.charAt(0));
            }
            return stringList;
        }

    }

    public static void main(String[] args){
         Permute permute = new Permute("ABC");
        permute.printAll();
    }
}
