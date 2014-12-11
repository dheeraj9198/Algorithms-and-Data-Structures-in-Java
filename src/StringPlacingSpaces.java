import java.util.ArrayList;
import java.util.List;

/**
 * User: dheeraj
 * Given a string you need to print all possible strings that can be made by
 * placing spaces (zero or one) in between them.
 * For example : ABC -> A BC, AB C, ABC, A B C
 */
public class StringPlacingSpaces {
    String string;

    public StringPlacingSpaces(String s){
        this.string = s;
    }

    public void printAll()
    {
      List<String> stringList = getCombinations(string);
        for(String s:stringList){
            System.out.println(s);
        }
    }

    public List<String> getCombinations(String s){
        if(s.length() == 1){
            List<String> stringList = new ArrayList<String>();
            stringList.add(s);
            return  stringList;
        }

        List<String> stringList = new ArrayList<String>();
        List<String> stringList1 = getCombinations(s.substring(1,s.length()));
        for(String s1 : stringList1){
            stringList.add(s.charAt(0)+s1);
            stringList.add(s.charAt(0)+" "+s1);
        }
        return stringList;
    }

    public static void main(String[] args){
        StringPlacingSpaces stringPlacingSpaces = new StringPlacingSpaces("ABCD");
        stringPlacingSpaces.printAll();
    }


}
