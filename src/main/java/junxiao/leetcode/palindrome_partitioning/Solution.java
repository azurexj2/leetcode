package junxiao.leetcode.palindrome_partitioning;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<String>> partition(String s){
		List<List<String>> res = new ArrayList<>();
		if (s.length()==0) return res;
		List<String> path = new ArrayList<>();
		dfs(s, res, path);
		return res;
	}
	private void dfs(String s, List<List<String>> res, 
			    List<String> path){
		if (s.length()==0){
			res.add(path.stream().collect(Collectors.toList()));
			return;
		}
		for (int pos=0;pos<s.length();++pos){
		if (isParlindrome(s, 0, pos)){
			path.add(s.substring(0,pos+1));
			dfs(s.substring(pos+1), res, path);
			path.remove(path.size()-1);
		}
		}

		
	}
	private boolean isParlindrome(String s,int i, int j){
		while(i<j){
			if (i<j && s.charAt(i)==s.charAt(j)){
				++i;
				--j;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
