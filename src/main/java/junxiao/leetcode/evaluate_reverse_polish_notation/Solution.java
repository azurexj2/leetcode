package junxiao.leetcode.evaluate_reverse_polish_notation;

import java.util.*;

public class Solution {
	public int evalRPN(String[] tokens){
		int len = tokens.length;
		if (len == 0) return 0;
		Deque<String> stack = new ArrayDeque<>();
		for (String str : tokens){
			if (str.equals("+")){
				int r = Integer.parseInt(stack.removeFirst());
				int l = Integer.parseInt(stack.removeFirst());
				int sum = r+l;
				stack.addFirst(String.valueOf(sum));
			}
			else if (str.equals("-")){
				int r = Integer.parseInt(stack.removeFirst());
				int l = Integer.parseInt(stack.removeFirst());
				int sum = l-r;
				stack.addFirst(String.valueOf(sum));
			}
			else if (str.equals("*")){
				int r = Integer.parseInt(stack.removeFirst());
				int l = Integer.parseInt(stack.removeFirst());
				int sum = l*r;
				stack.addFirst(String.valueOf(sum));
			}
			else if (str.equals("/")){
				int r = Integer.parseInt(stack.removeFirst());
				int l = Integer.parseInt(stack.removeFirst());
				int sum = l/r;
				stack.addFirst(String.valueOf(sum));
			}
			else {
				stack.addFirst(str);
			}
		}
		return Integer.parseInt(stack.removeFirst());
	}
}
