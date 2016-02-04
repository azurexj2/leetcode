package junxiao.leetcode.unique_binary_search_trees;

import java.util.*;

public class Solution {
	public int numTrees(int n){
		if (n<=1) return 1;
		int[] F = new int[n+1];
		F[0] = 1;
		F[1] = 1;
		for(int i = 2;i<=n;++i){
			for(int j=1;j<=i;++j){
				F[i]+= (F[j-1]*F[i-j]);
			}
		}
		return F[n];
	}
}
