package junxiao.leetcode;
import java.util.*;
import junxiao.leetcode.implement_trie_prefix_tree.*;

public class runLeetcode {
    public static void main(String[] args){
// two_sum.Solution s = new two_sum.Solution();
    	Trie trie = new Trie();
    	trie.insert("ab");
    	boolean res = trie.search("a");
    	res = trie.startsWith("a");
        }
}


