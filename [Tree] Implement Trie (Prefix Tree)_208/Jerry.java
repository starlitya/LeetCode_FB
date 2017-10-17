class Trie {

    public static class TreeNode {
        boolean isWord;
        TreeNode [] child = new TreeNode[26]; //a-z
    }
    
    TreeNode mRoot;
    
    /** Initialize your data structure here. */
    public Trie() {
        mRoot = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length()==0) {
            return;
        }
        
        TreeNode tempNode = mRoot;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (tempNode.child[c - 'a'] == null) {
                tempNode.child[c - 'a'] = new TreeNode();
            } 
            
            tempNode = tempNode.child[c - 'a'];
        }
        
        // Carefull to make should to end of node, instead of word.length()-1
        tempNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode tempNode = mRoot;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (tempNode.child[c - 'a'] == null) {
                return false;
            }
            
            tempNode = tempNode.child[c - 'a'];
        }
        
        return tempNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode tempNode = mRoot;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tempNode.child[c - 'a'] == null) {
                return false;
            }
            
            tempNode = tempNode.child[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */