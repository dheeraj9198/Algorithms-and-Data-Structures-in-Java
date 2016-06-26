class Trie {

    private static Node root = new Node('*', false);

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

    public static void main(String[] args) {
        insert("abc", root);
        insert("xyz", root);
        insert("abcd", root);
		
		System.out.println(find("abc",root));
		System.out.println(find("abcd",root));
		System.out.println(find("ab",root));
		System.out.println(find("xyz",root));
    }


}