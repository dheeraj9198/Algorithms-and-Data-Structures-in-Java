package trie;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: windows 7
 * Date: 12/10/14
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrieDheerajBad {

    public static class Node {
        boolean key;
        HashMap<Character, Node> characterNodeHashMap;

        public Node() {
            key = false;
            characterNodeHashMap = new HashMap<Character, Node>();
        }
    }

    public static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String data) {
            data = data.toLowerCase();
            Node temp = root;
            for (int x = 0; x < data.length(); x++) {
                if (!temp.characterNodeHashMap.containsKey(data.charAt(x))) {
                    temp.characterNodeHashMap.put(data.charAt(x), new Node());
                }
                temp = temp.characterNodeHashMap.get(data.charAt(x));
            }
            //word ends here
            temp.key = true;
        }

        public boolean search(String data) {
            data = data.toLowerCase();
            Node temp = root;
            for (int x = 0; x < data.length(); x++) {
                if (!temp.characterNodeHashMap.containsKey(data.charAt(x))) {
                    return false;
                }
                temp = temp.characterNodeHashMap.get(data.charAt(x));
            }
            // if word actually ended here then this key is true, else false
            // there may be a case that all words may have been found but the ending node might not be a word
            return temp.key;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dheeraj");
        trie.insert("sachan");

        System.out.println(trie.search("dheerajs"));


    }
}
