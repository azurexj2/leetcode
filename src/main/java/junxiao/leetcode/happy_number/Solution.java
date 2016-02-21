package junxiao.leetcode.happy_number;

import java.util.*;

public class Solution {
	public boolean isHappy(int n){
		Set<Integer> visited = new HashSet<>();
		visited.add(n);
		while(true){
			int num = squre(n);
			if (num==1) return true;
			if (!visited.add(num)){
				return false;
			}
			n = num;
		}
	}
	private int squre(int n){
		int sum = 0;
		while (n>0){
			int m = n %10;
			sum += (m*m);
			n /= 10;
		}
		return sum;
	}
}
