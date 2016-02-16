package junxiao.leetcode.reverse_words_in_a_string;

import java.util.*;

public class Solution {
	public String reverseWords(String s){
		//remember deal with heading and trainning zero
		// delete extra sapce between words
		int len = s.length();
		if (len<=1) return s;
		StringBuilder res = new StringBuilder();
		for (int start = len-1; start<=0; --start){
			while(start>=0 && s.charAt(start)==' '){
				--start;
			}
			//now start point to nonspace
			if (start<0) break;
			int end = start;
			while(start>=0 && s.charAt(start)!=' '){
				--start;
			}
			// now we have start+1 to end point to words
			res.append(s.substring(start+1,end+1));
		}
		return res.toString();
	}
}
