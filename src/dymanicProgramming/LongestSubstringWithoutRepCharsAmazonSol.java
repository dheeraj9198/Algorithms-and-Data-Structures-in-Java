package dymanicProgramming;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by dheeraj on 7/14/2016.
 * Length of the longest substring without repeating characters
 * the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 */
public class LongestSubstringWithoutRepCharsAmazonSol {


    public static void main(String[] ss) {
        String s = "ABDEFGABE98765432F123";
        int start = 0;
        int length = 1;

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<Character, Integer>();
        List<String> strings1 = new ArrayList<String>();
        characterIntegerHashMap.put(s.charAt(0), 0);
        for (int k = 1; k < s.length(); k++) {
            if (characterIntegerHashMap.containsKey(s.charAt(k))) {
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
                int num = characterIntegerHashMap.get(s.charAt(k));
                start = num + 1;
                Iterator<Entry<Character, Integer>> iter = characterIntegerHashMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Character, Integer> entry = iter.next();
                    if (entry.getValue() <= num) {
                        iter.remove();
                    }
                }
            }
            characterIntegerHashMap.put(s.charAt(k), k);
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
