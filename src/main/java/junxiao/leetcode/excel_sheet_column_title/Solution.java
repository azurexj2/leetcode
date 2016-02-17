package junxiao.leetcode.excel_sheet_column_title;

import java.util.*;

public class Solution {
	public String convertToTitle(int n){
		StringBuilder res = new StringBuilder();
		while(n!=0){
			int q = (n-1)%26;
			res.append((char)'A'+q);
			n = (n-1)/26; 
		}
		return res.reverse().toString();
	}
}
