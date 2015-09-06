import java.util.*;

public class myTrie {
	private TrieNode root;

    public myTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie. e.g. insert team into a trie with tea
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            TrieNode tmp;
            if(children.containsKey(c)){
                tmp = children.get(c); //t -> e-> a
            }else{
                tmp = new TrieNode(c);
                children.put(c, tmp); // add m
            }
            children = tmp.children;
            //set leaf node
            if(i == word.length() - 1){
                tmp.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if(t != null && t.isLeaf){ //e.g. tea v.s team
            return true;
        }else{
            return false;
        }
    }
    //Search a node from the trie
    public TrieNode searchNode(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode tmp = null;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){ //go to next level
                tmp = children.get(c);// tmp values changes from t to te
                children = tmp.children;
            }else{
                return null;
            }
        }
        return tmp;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null){
            return false;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// myTrie trie = new myTrie();
// myTrie.insert("somestring");
// myTrie.search("key");
