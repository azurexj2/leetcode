package junxiao.leetcode.generate_parentheses;

import java.util.*;

public class Solution {
	public List<String> generateParenthesis(int n){
		List<String> res = new ArrayList<>();
		String pat = new String();
		dfs(res,pat,n,n);
		return res;
	}
	
	public void dfs(List<String> res, String pattern, int L, int R){
		if (L<0 || R<0) return;
		if (L<R) return;
		if (L==0 && R==0){
			res.add(pattern);
			return;
		}
		
		dfs(res,pattern+'(',L-1,R);
		dfs(res,pattern+')',L,R-1);
	}
}
