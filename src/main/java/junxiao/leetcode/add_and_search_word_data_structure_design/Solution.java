package junxiao.leetcode.add_and_search_word_data_structure_design;

import java.util.*;

import com.sun.security.auth.NTDomainPrincipal;

class TrieNode {
	public boolean wordEnd;
	TrieNode[] children;
	public TrieNode(){
		children = new TrieNode[26];
	}
}

public class WordDictionary {
	private TrieNode root;
	public WordDictionary(){
		root = new TrieNode();
	}

    // Adds a word into the data structure.
    public void addWord(String word) {
    	if (word==null) return;
    	TrieNode cur = root;
    	for (int i = 0; i < word.length(); ++i){
    		int ind = word.charAt(i) - 'a';
    		if (cur.children[ind]==null){
    			cur.children[ind] = new TrieNode();
    		}
    		cur = cur.children[ind];
    	}
    	cur.wordEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if (word==null) return false;
    	return doSearch(root, word);
        
    }
    public boolean doSearch(TrieNode node, String word){
    	if (node==null || word==null) return false;
    	if (word.length()==0) return node.wordEnd;
    	if (word.charAt(0)!='.'){
    		int ind = word.charAt(0)-'a';
    		if (node.children[ind]==null){
    			return false;
    		}
    		return doSearch(node.children[ind], word.substring(1));
    	}
    	//'.'case
    	for (int i=0; i<26;++i){
    		if (node.children[i]!=null){
    			if( doSearch(node.children[i], word.substring(1))){
    				return true;
    			}
    		}
    	}
    	return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");