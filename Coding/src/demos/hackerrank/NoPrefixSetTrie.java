package demos.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NoPrefixSetTrie {
    /*
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     *
     * N-th is checked against 1-(N-1)-th elements
     */

    public static void noPrefix(List<String> words) {
        // Write your code here
        Trie trie = new Trie();
        for (String word : words) {
            if (trie.prefixExists(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
            trie.addWord(word);
        }
        System.out.println("GOOD SET");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        noPrefix(words);

        bufferedReader.close();
    }
}

class TrieNode {
    private char data;
    private int numOfChildren = 'j' - 'a' +1;
    private boolean isWord;
    private boolean hasChildren;
    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[numOfChildren];
    }
    public TrieNode(char data) {
        this();
        this.data = data;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public TrieNode addChild(char c) {
        return addChild(c, false);
    }
    public TrieNode addChild(char c, boolean isEndChar) {
        int pos = c - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode(c);
        }
        if (!hasChildren) hasChildren = true;
        if (isEndChar) isWord = true;
        return children[pos];
    }
    public char getData() {
        return data;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isWord() {
        return isWord;
    }

    public boolean hasChildren() {
        return hasChildren;
    }

}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.addChild(c);
        }
        node.setIsWord(true);
    }

    public boolean prefixExists(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int pos = c - 'a';
            node = node.getChildren()[pos];
            if ( node == null) return false;
            if (node.isWord()) {   // Prefix for word exists as word
                return true;
            }
        }
        if (node != null && node.hasChildren()) {   // word is prefix to other word
            return true;
        }
        return false;
    }
}
