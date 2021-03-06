package junxiao.leetcode.wildcard_matching;

import java.util.*;

public class Solution {
	public boolean isMatch(String s, String p){
		if (s==null | p ==null) return false;
		int lenS = s.length();
		int lenP = p.length();
		// matched[i][j] indicate s[0,i-1] p[0,j-1] is matched or not
		boolean[][] matched = new boolean[lenS+1][lenP+1];
		matched[0][0] = true;
		//matched[0][j] indicate empty s 
		for (int i = 1; i<=lenP;++i){
			if (p.charAt(i-1)!='*')
				break;
			else
                matched[0][i] = true;
		}
		for (int i = 1; i<=lenS;++i){
			for (int j = 1; j <=lenP; ++j){
				int charS = s.charAt(i-1);
				int charP = p.charAt(j-1);
				if (charP==charS || charP=='?'){
					matched[i][j] = matched[i-1][j-1];
				}
				else if (charP == '*'){
					//"*" matches:
					//1. ""
					//2. "x"
					//3. "xx..."
                    matched[i][j] = matched[i][j-1] || matched[i-1][j-1] || matched[i-1][j];
				}
				
			}
		}
		return matched[lenS][lenP];
	}
}
