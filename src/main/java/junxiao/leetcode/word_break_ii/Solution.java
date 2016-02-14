package junxiao.leetcode.word_break_ii;

import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Solution {
	public List<String> wordBreak(String s, Set<String> wordDict){
		int len = s.length();
		boolean[] isWords = new boolean[len+1];
		isWords[len] = true;
		//cut[i][j] contains the [i,j] is valid cut
		//as s(i,j) + cut[j+1]
		List<List<Integer>> cut = new ArrayList<>();
		for(int i=len-1;i>=0;--i){
			List<Integer> path = new ArrayList<>();
			for (int j=i;j<len;++j){
				if (isWords[j+1] && wordDict.contains(s.substring(i,j+1))){
					isWords[i]=true;
					path.add(j);
				}
			}
			cut.add(path);
		}
		//now cut store all the cut information
		List<String> res = new ArrayList<>();
		if (!isWords[0])
			return res;
		List<String> words = new ArrayList<>();
		dfs(s, cut, res, words, 0);
		return res;
	}
	private void dfs(String s, List<List<Integer>> cut, 
			List<String> res, List<String> words,int pos){
		if (pos>=s.length()){
			String str = String.join(" ", words);
			res.add(str);
			return;
		}
		for (Integer num : cut.get(cut.size()-1-pos)){
			words.add(s.substring(pos,num+1));
			dfs(s, cut, res, words, pos+num+1);
			words.remove(words.size()-1);
		}
		
	}
}
