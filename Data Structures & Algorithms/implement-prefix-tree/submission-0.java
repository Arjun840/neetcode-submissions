public class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if (cur.children[i] == null){ // if ;letter is not present, make a new tree starting with the letter
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i]; // set the pointer to the new tree
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()){
            int i = c - 'a';
            if (cur.children[i] == null){
                return false;
            }
            cur = cur.children[i]; // iterate to next child
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()){
            int i = c - 'a';
            if (cur.children[i] == null){
                return false;
            }
            cur = cur.children[i];
        }
        return true;
    }
}
