package trie;

import java.util.ArrayList;
import java.util.List;

class Trie {

    private static Node root = new Node(' ', false);

    static int getIndex(char x) {
        return ((int) x) - ((int) 'a');
    }

    static class Node {
        char data;
        boolean isLeaf;
        Node[] children;

        Node(char data, boolean leaf) {
            this.data = data;
            this.isLeaf = leaf;
            this.children = new Node[26];
        }

    }

    static void insert(String data, Node root) {
        if (data == null || data.length() == 0) {
            return;
        }
        Node child = root.children[getIndex(data.charAt(0))];
        if (child == null) {
            Node node = new Node(data.charAt(0), data.length() == 1);
            root.children[getIndex(data.charAt(0))] = node;
            if (data.length() > 1) {
                insert(data.substring(1, data.length()), node);
            }
        } else {
            if (data.length() == 1) {
                child.isLeaf = true;
            } else {
                insert(data.substring(1, data.length()), child);
            }
        }
    }

    static boolean find(String data, Node root) {
        if (data == null || data.length() == 0) {
            return true;
        }
        char x = data.charAt(0);
        //note that first node ie root is just dummy, it just holds important
        Node node = root.children[getIndex(x)];
        if (node == null) {
            return false;
        } else {
            if (data.length() == 1) {
                return node.isLeaf;
            } else {
                return find(data.substring(1, data.length()), node);
            }
        }
    }

    static boolean delete(String data, Node root) {
        if (data == null || data.length() == 0) {
            return false;
        }
        char x = data.charAt(0);
        //note that first node ie root is just dummy, it just holds important
        Node node = root.children[getIndex(x)];
        if (node == null) {
            return false;
        } else {
            if (data.length() == 1) {
                node.isLeaf = false;
                boolean allNull = true;
                for (Node node1 : node.children) {
                    allNull = allNull && node1 == null;
                }
                return allNull;
            } else {
                boolean delete = delete(data.substring(1, data.length()), node);
                if (delete) {
                    node.children[getIndex(x)] = null;
                    if(node.isLeaf){
                        return false;
                    }
                    boolean allNull = true;
                    for (Node node1 : node.children) {
                        allNull = allNull && node1 == null;
                    }
                    return allNull;                }
            }
        }
        return false;
    }


    private static List<String> strings = new ArrayList<>();

    private static List<String> getAll() {
        strings = new ArrayList<String>();
        findAllDFS(root, "");
        return strings;
    }

    private static void findAllDFS(Node node, String old) {
        if (node != null) {
            if (node.data != ' ') {
                old = old + node.data;
            }
            if (node.isLeaf) {
                strings.add(old);
            }
            for (Node node1 : node.children) {
                findAllDFS(node1, old);
            }
        }
    }

    public static void main(String[] args) {
        insert("abc", root);
        insert("xyz", root);
        insert("abcd", root);
        insert("abcde", root);


        delete("abcd", root);

 /*       System.out.println(find("abc", root));
        System.out.println(find("abcd", root));
        System.out.println(find("ab", root));
        System.out.println(find("xyz", root));*/


        System.out.println(getAll());
    }


}