package junxiao.leetcode.valid_palindrome;

import java.util.*;

public class Solution {
	public boolean isPalindrome(String s){
		int len = s.length();
		if (len==0) return true;
		int ind_l = 0, ind_r = len -1;
		String str = s.toLowerCase();
		while (ind_l < ind_r){
			while(ind_l<ind_r && !Character.isLetterOrDigit(str.charAt(ind_l))){
				++ind_l;
			}
			while(ind_l<ind_r && !Character.isLetterOrDigit(str.charAt(ind_r))){
				--ind_r;
			}
			if (str.charAt(ind_l)==str.charAt(ind_r)){
				ind_l++;
				ind_r--;
			}
			else 
				return false;
			
			
		}
		return true;
		
	}
}
