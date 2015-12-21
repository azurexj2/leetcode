package junxiao.leetcode.zigzag_conversion;

import java.util.*;

public class Solution {
	 public String convert(String s, int numRows) {
		 if (s.length() <= 1 || numRows <= 1) return s;
		 StringBuilder[] str = new StringBuilder[numRows];
		 for (int i = 0; i < numRows; ++i){
			 str[i] = new StringBuilder("");
		 }
		 int step = 1;
		 int pos = 0;
		 for (int i = 0; i < s.length(); ++i){
			 str[pos].append(s.charAt(i));
			 if (pos == 0) {
				 step = 1;
			 }
			 else if (pos == numRows-1){
				 step = -1;
			 }
			 
			 pos += step;
		 }
		 String res = String.join("", str);
		 return res;
	 }
}
