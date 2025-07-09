import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Array.sort
        Trie root = new Trie(); // create the trie
        for (String product : products) {
            root.insert(product); // insert each product into trie
        }
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root.root;
        for (char ch : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[ch - 'a']; //index 
            }
            if (node != null) {
                result.add(node.suggestions); // node found (add in suggestion)
            } else {
                result.add(new ArrayList<>()); // no match 
            }
        }
        return result;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }
    class Trie {
        TrieNode root = new TrieNode();
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(word);
                }
            }
        }
    }
}
