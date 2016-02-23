package junxiao.leetcode.longest_valid_parentheses;

import java.util.*;

import com.sun.org.apache.bcel.internal.generic.INEG;

public class Solution {
	public int longestValidParentheses(String s){
		int len = s.length();
		if (len<=1) return 0;
		int maxLen = 0;
		int[] matchedLen = new int[len];
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i =0; i <len;++i){
			if (s.charAt(i)=='('){
				stack.addFirst(i);
			}
			else if (!stack.isEmpty()){
				int ind = stack.removeFirst();
				int curLen = i - ind +1 + matchedLen[i-1];
				maxLen = Math.max(maxLen, curLen);
				matchedLen[i] = curLen;
			}
		}
		return maxLen;
	}
	public int longestValidParentheses2(String s){
		int len = s.length();
		if (len<=1) return 0;
		int maxLen = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		int lastUnmatchedInd = -1;
		for (int i =0; i <len;++i){
			if (s.charAt(i)=='('){
				stack.addFirst(i);
			}
			else {
				if (!stack.isEmpty()){
					//not match
					lastUnmatchedInd = i;
				}
				else {
					// have match
					int ind = stack.removeFirst();
					int curLen = 0;
					if (stack.isEmpty()){
						// no '(' left, then len include lastUnmatched+1 ')'
						curLen = i - (lastUnmatchedInd+1) +1;
					}
					else {
						//has '(' left, mean no ')' between it with i,
						// '('+1
						curLen = i - ind +1;
					}
					maxLen = Math.max(maxLen, curLen);
				}
			}
		}
		return maxLen;

	}
}
