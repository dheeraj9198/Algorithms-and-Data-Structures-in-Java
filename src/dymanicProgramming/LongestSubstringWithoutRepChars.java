package dymanicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * Created by dheeraj on 7/14/2016.
 * Length of the longest substring without repeating characters
 * the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 */
public class LongestSubstringWithoutRepChars {


    public static void main(String[] ss) {
        String s = "ABDEFGABEF";
        int start = 0;
        int length = 1;

        int[] map = new int[256];

        List<String> strings1 = new ArrayList<String>();
        map[s.charAt(0)]=0;
        for (int k = 1; k < s.length(); k++) {
            if (map[s.charAt(k)] >= start) {
                if (k - start >= length) {
                    length = k - start;
                    Iterator<String> stringIterator = strings1.iterator();
                    while(stringIterator.hasNext()){
                        String s1 = stringIterator.next();
                        if(s1.length() < length){
                            stringIterator.remove();
                        }
                    }
                    strings1.add(s.substring(start, k));
                }
                int num = map[s.charAt(k)];
                start = num + 1;

            }
            map[s.charAt(k)]=k;
        }
        if (s.length() - start >= length) {
            length = s.length() - start;
            Iterator<String> stringIterator = strings1.iterator();
            while(stringIterator.hasNext()){
                String s1 = stringIterator.next();
                if(s1.length() < length){
                    stringIterator.remove();
                }
            }
            strings1.add(s.substring(start, s.length()));
        }
        System.out.print(strings1);
    }
}
