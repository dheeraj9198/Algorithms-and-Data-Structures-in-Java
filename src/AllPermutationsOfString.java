import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/10/14
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AllPermutationsOfString {

    public static class Permute {
        public String string;

        public Permute(String s) {
            string = s;
        }

        public void printAll() {
            HashSet<String> stringList = printAllPermutations(string);
            for (String s : stringList) {
                System.out.println(s);
            }
        }

        public HashSet<String> printAllPermutations(String string) {
            if (string.length() == 1) {
                HashSet<String> stringList = new HashSet<String>();
                stringList.add(string);
                return stringList;
            }

            HashSet<String> list = printAllPermutations(string.substring(1, string.length()));
            HashSet<String> stringList = new HashSet<String>();
            for (String s : list) {
                for(int i =0;i<=s.length();i++){
                    stringList.add(permute(string.charAt(0), s, i));
                }
            }
            return stringList;
        }

        private String permute(char start,String string,int index){
            String one = string.substring(0,index);
            String two = string.substring(index);
            return one+start+two;
        }
    }



    public static void main(String[] args) {
        Permute permute = new Permute("ABC");
        permute.printAll();
    }
}
