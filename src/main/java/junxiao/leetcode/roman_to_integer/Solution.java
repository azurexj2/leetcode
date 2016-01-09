package junxiao.leetcode.roman_to_integer;

import java.util.*;

public class Solution {
	public int romanToInt(String s){
		HashMap<Character,Integer> table = new HashMap<>();
		table.put('I', 1);
		table.put('V', 5);
		table.put('X', 10);
		table.put('L', 50);
		table.put('C', 100);
		table.put('D', 500);
		table.put('M', 1000);
		int sum = 0;
		int pre = 0, cur = 0;
		for (int i=0; i < s.length(); ++i){
			cur = table.get(s.charAt(i));
			if (cur<=pre){
				sum += cur;
			}
			else {
				sum -= (pre*2);
				sum += cur;
			}
			pre = cur;
		}
		return sum;
		
	}
}
