package junxiao.leetcode.climbing_stairs;

import java.util.*;

public class Solution {
	public int climbStairs(int n){
   		//f(n) = f(n-1) + f(n-2)
	//       cur       pre
	if (n==1) return 1;
	if (n==2) return 2;
	int pre = 1;
	int cur = 2;
	for (int i = 3; i <=n; ++i){
	    int tmp = cur;
		cur += pre;
		pre = tmp;
	}
	return cur; 

	}
}
