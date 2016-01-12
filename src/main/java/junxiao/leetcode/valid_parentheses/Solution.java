package junxiao.leetcode.valid_parentheses;

import java.util.*;

public class Solution {
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<>();
		for (int i =0; i < s.length(); ++i){
			if (s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
				stack.push(s.charAt(i));
			}
			else if (s.charAt(i)=='}'){
				if (stack.empty()) return false;
				char c = stack.pop();
				if (c!='{') return false;
			}
			else if (s.charAt(i)==')'){
				if (stack.empty()) return false;
				char c = stack.pop();
				if (c!='(') return false;
			}
			else if (s.charAt(i)==']'){
				if (stack.empty()) return false;
				char c = stack.pop();
				if (c!='[') return false;
			}
		}
		return stack.empty() ? true : false;
		
	}
}
