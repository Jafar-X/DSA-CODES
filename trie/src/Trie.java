
import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    //insert iteratively
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isEndOfWord = true;
    }

    public void insertRecursive(String word) {
        insertRecursive(word, 0, root);
    }

    public void insertRecursive(String word, int index, TrieNode current) {
        if(index == word.length()) {
            current.isEndOfWord = true;
            return;
        }
        char ch = word.charAt(index);

        TrieNode node = current.children.get(ch);
        if(node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        current = node;
        insertRecursive(word, index + 1, current);

    }

    //Search iteratively
    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    public boolean recursiveSearch(String word) {
       return recursiveSearch(word, 0, root);
    }

    public boolean recursiveSearch(String word, int index, TrieNode current) {
        if(word.length() == index) {
            return current.isEndOfWord;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null) {
            return false;
        }
        return recursiveSearch(word, index + 1, node);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("ABC");
        t.insert("DEF");
        System.out.println(t.search("ABC"));
        System.out.println(t.search("SL"));
    }

    //TODO: to add delete functionality
}
