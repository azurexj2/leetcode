package junxiao.leetcode.valid_number;

import java.util.*;


public class Solution {
	public boolean isNumber(String s){
        if (s==null || s.length()==0) return false;
		int[][] table = {
				{1,2,8,-1},
				{-1,2,8,-1},
				{-1,2,3,4},
				{-1,7,-1,4},
				{5,6,-1,-1},
				{-1,6,-1,-1},
				{-1,6,-1,-1},
				{-1,7,-1,4},
				{-1,7,-1,-1}
		};
		
		int sym=0;
		String str = s.trim();
		int state = 0;
		for (int i = 0; i<str.length();++i){
			char c = str.charAt(i);
			if (Character.isDigit(c)){
				sym = 1;
			}
			else if (c=='+' || c=='-'){
				sym = 0;
			}
			else if (c=='.'){
				sym = 2;
			}
			else if (c=='e' || c=='E'){
				sym = 3;
			}
			else 
				return false;
			
			state = table[state][sym];
			if (state==-1) return false;
		}
		if (state == 2 || state==6 || state==7 || state==3){
			return true;
		}
		return false;
	}
}
