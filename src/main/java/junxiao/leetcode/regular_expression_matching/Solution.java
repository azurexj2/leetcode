package junxiao.leetcode.regular_expression_matching;

import java.util.*;

public class Solution {
	public boolean isMatch(String s, String p){
  		int len1 = s.length();
	int len2 = p.length();
	if (len1 ==0 && len2==0) return true;
	if (len2 ==0) return false;
	char p1 = p.charAt(0);
	if (len2==1){
	    if (len1 != 1) return false;
		if (p1=='.' || s.charAt(0)==p1){
			return true;
		}
		else 
		    return false;
	}
	else if (p.charAt(1)=='*'){
		
		// a* or .*
		if (isMatch(s,p.substring(2)))
  		    return true;
		int i = 0;
		while( i < len1 && (p1=='.' || s.charAt(i)==p1)){
			if (isMatch(s.substring(i+1), p.substring(2))){
				return true;
			}
			++i;
		}
	}
	else {
	    if (len1==0) return false;
		return (s.charAt(0)==p.charAt(0) || p1=='.')? isMatch(s.substring(1), p.substring(1))
				  : false;
	}
	return false;
	}
	public boolean isMatch2(String s, String p){
		int lenS = s.length();
		int lenP = p.length();
		boolean[][] match =  new boolean[lenS+1][lenP+1];
		match[0][0] = true;
		// here to find the "x*" match empty "" case,
		//match[i][j] is whether s(0,i-1) and p(0,j-1)
		// as a result, match[0][j] need test,
		// match[i][0] if false
		for (int j = 1; j < lenP; ++j){
			if (p.charAt(j-1)!='*'){
				match[0][j] = false;
			}
			else {
				match[0][j] = match[0][j-2];
				if (!match[0][j])
					break;
			}
		}
		for (int i = 1; i<lenS; ++i){
			for (int j = 1; j<lenP;++j){
				if (p.charAt(j-1)=='.' || p.charAt(j-1)==s.charAt(i-1)){
					match[i][j] = match[i-1][j-1];
				}
				else if (p.charAt(j-1)=='*'){
					//1. "x*" match ""
					match[i][j] = match[i][j-2];
					if (p.charAt(j-2)=='.'|| p.charAt(j-2)==s.charAt(i-1)){
						//2. "x*" match "x"
						//3. "x*" match "...xx"
						match[i][j] = match[i][j] || match[i-1][j-2] || match[i-1][j]; 
					}
				}
			}
		}
		return match[lenS][lenP];
		
	}
}
