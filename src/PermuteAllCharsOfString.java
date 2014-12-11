import java.util.HashSet;
import java.util.Set;

/**
 * Created by sujeet on 11/12/14.
 */
public class PermuteAllCharsOfString {
    public String string;

    public PermuteAllCharsOfString(String s){
        string  = s;
    }

    public void printAllPermutations(){
        HashSet<String> stringSet = permuteAll(string);
        for(String s:stringSet){
            System.out.println(s);
        }
    }

    private HashSet<String> permuteAll(String string){
        if(string.length() == 1){
            HashSet<String> strings = new HashSet<String>();
            strings.add(string);
            return strings;
        }else{
            char start = string.charAt(0);
            String rest = string.substring(1);
            HashSet<String> tempHashSet = permuteAll(rest);
            HashSet<String> hashSet = new HashSet<String>();
            for(String s : tempHashSet){
                for(int x =0;x<s.length()+1;x++){
                    hashSet.add(combine(start, s, x));
                }
            }
            return hashSet;
        }
    }

    private String combine(char start,String rest,int index) {
        String part1 = rest.substring(0,index);
        String part2 = rest.substring(index);
        return part1+start+part2;
    }

    public static void main(String[] args){
        PermuteAllCharsOfString permuteAllCharsOfString = new PermuteAllCharsOfString("TEST");
        permuteAllCharsOfString.printAllPermutations();
    }

}
