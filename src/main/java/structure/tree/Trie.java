package structure.tree;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }


    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];

        private TrieNode() {
        }

        private TrieNode(char c) {
            this.val = c;
        }

    }
}
