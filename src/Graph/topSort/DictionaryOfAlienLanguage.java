package Graph.topSort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dheeraj on 8/7/16.
 *
 * https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * https://www.geeksforgeeks.org/topological-sorting/
 *
 * Given a sorted dictionary of an alien language, find order of characters
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 *
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 */
public class DictionaryOfAlienLanguage {

    private static HashMap<Character, LinkedList<Character>> characterLinkedListHashMap = new HashMap<Character, LinkedList<Character>>();
    private static HashMap<Character, Boolean> visitedHashMap = new HashMap<Character, Boolean>();

    private static void addKeyValue(Character key, Character value) {
        if (characterLinkedListHashMap.containsKey(key)) {
            characterLinkedListHashMap.get(key).add(value);
        } else {
            LinkedList<Character> characters = new LinkedList<Character>();
            characters.add(value);
            characterLinkedListHashMap.put(key, characters);
        }
        if (!characterLinkedListHashMap.containsKey(value)) {
            characterLinkedListHashMap.put(value, new LinkedList<Character>());
        }
        visitedHashMap.put(key, false);
        visitedHashMap.put(value, false);
    }

    private static void addShit(String first, String second) {
        int x = 0, y = 0;
        while (x < first.length() && y < second.length()) {
            if (first.charAt(x) == second.charAt(y)) {
                x++;
                y++;
            } else {
                addKeyValue(first.charAt(x), second.charAt(y));
                return;
            }
        }
    }

    private static void topSort(Character character, Stack<Character> characterStack) {
        visitedHashMap.put(character, true);
        for (Character character1 : characterLinkedListHashMap.get(character)) {
            if (!visitedHashMap.get(character1)) {
                topSort(character1, characterStack);
            }
        }
        characterStack.push(character);
    }

    public static void main(String[] strings) {
        String[] words = new String[]{"baa", "abcd", "abca", "cab", "cad"};
        for (int k = 1; k < words.length; k++) {
            addShit(words[k - 1], words[k]);
        }

        Stack<Character> characterStack = new Stack<Character>();
        for (Character s : characterLinkedListHashMap.keySet()) {
            if (!visitedHashMap.get(s)) {
                topSort(s, characterStack);
            }
        }
        while (!characterStack.empty()) {
            System.out.print(characterStack.pop()+" ");
        }


    }


}
