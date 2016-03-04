package junxiao.leetcode.implement_trie_prefix_tree;

import java.util.*;

import com.sun.corba.se.impl.orbutil.graph.Node;

class TrieNode {
    // Initialize your data structure here.
	public char c;
	public TrieNode[] children;
	public boolean wordEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.wordEnd = true;
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word==null || word.length()==0) return;
    	int ind = word.charAt(0)-'a';
    	if (root.children[ind]==null){
    		root.children[ind] = new TrieNode();
    	}
    	doInsert(root.children[ind], word);
        
    }
    public void doInsert(TrieNode node, String word){
    	node.c = word.charAt(0);
    	if (word.length()==1){
    		node.wordEnd = true;
    		return;
    	}
    	int ind = word.charAt(1)-'a';
    	if (node.children[ind]==null){
    		node.children[ind] = new TrieNode();
    	}
    	doInsert(node.children[ind], word.substring(1));
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word.length()==0)
    		return true;
    	return doSearch(root.children[word.charAt(0)-'a'], word);
    }
    private boolean doSearch(TrieNode node, String word){
    	if (node==null) return false;
    	if (word.length()==1){
    		if (node.wordEnd && node.c == word.charAt(0))
    			return true;
    		else 
    			return false;
    	}
    	return doSearch(node.children[word.charAt(1)-'a'], word.substring(1));
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix==null) return false;
    	if (prefix.length()==0) return true;
        return doStartsWith(root.children[prefix.charAt(0)-'a'], prefix); 
    }
    private boolean doStartsWith(TrieNode node, String prefix){
    	if (node ==null) return false;
    	if (prefix.length()==1){
    		if (node.c == prefix.charAt(0))
    			return true;
    		else 
    			return false;
    	}
    	return doStartsWith(node.children[prefix.charAt(1)-'a'], prefix.substring(1));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
public class Trie2 {
    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word==null) return;
    	TrieNode cur = root;
    	for (int i = 0; i<word.length();++i){
    		int ind = word.charAt(i)-'a';
    		if (cur.children[ind]==null){
    			cur.children[ind] = new TrieNode();
    		}
    		cur = cur.children[ind];
    	}
    	cur.wordEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word==null) return false;
    	TrieNode cur = root;
    	for (int i =0; i<word.length();++i){
    		int ind = word.charAt(i)-'a';
    		if (cur.children[ind]==null)
    			return false;
    		cur = cur.children[ind];
    	}
    	return cur.wordEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix==null) return false;
    	TrieNode cur = root;
    	for (int i =0; i<prefix.length();++i){
    		int ind = prefix.charAt(i)-'a';
    		if (cur.children[ind]==null)
    			return false;
    		cur = cur.children[ind];
    	}
    	return true;
        
    }
}
