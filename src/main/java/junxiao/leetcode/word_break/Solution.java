package junxiao.leetcode.word_break;

import java.util.*;

public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict){
		if (s.length()==0)return true;
		return dfs(wordDict, s);
	}
	private boolean dfs(Set<String> wordDict, String s){
		if (s.length()==0) return true;
		for(int i=0;i<s.length();++i){
			if (wordDict.contains(s.substring(0,i+1))){
				if (dfs(wordDict, s.substring(i+1))){
					return true;
				}
			}
		}
		return false;
	}
	public boolean wordBreak2(String s, Set<String> wordDict){
		int len = s.length();
		boolean[] isWords = new boolean[len+1];
		isWords[len] = true;
		for (int i=len-1;i>=0;--i){
			for(int j=i;j<len;++j){
				if (isWords[j+1] && wordDict.contains(s.substring(i,j+1))){
						isWords[i]=true;
						break;
				}
			}
		}
		return isWords[0];

	}	
}
