package junxiao.leetcode.longest_palindromic_substring;

import java.util.*;

public class Solution {
	public String longestPalindrome(String s) {
		if (s.length() <=1 ) return s;
		int L = s.length();
		boolean[][] F = new boolean[L][L];
		int maxL = 1;
		int begin = 0;
		for (int i = L-1; i >=0; --i){
			for (int j = i; j < L; ++j){
				if (j-i <=1) {
					F[i][j] = s.charAt(i)==s.charAt(j);
				}
				else {
					if (s.charAt(i)==s.charAt(j)){
						F[i][j] = F[i+1][j-1];
					}
					else {
						// s[i]!=s[j]
						F[i][j] = false;
					}
				}
				if (F[i][j] == true){
					int tmp = j - i + 1;
					if (tmp > maxL){
						//need update maxL, begin
						maxL = tmp;
						begin = i;
					}
				}
				
			}
		}

		return s.substring(begin, begin+maxL);
	}
}
