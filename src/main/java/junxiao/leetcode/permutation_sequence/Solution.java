package junxiao.leetcode.permutation_sequence;

import java.util.*;

public class Solution {
	public String getPermutation(int n, int k){
		String res = "";
		if (n==0) return res;
		List<Integer> nums = new ArrayList<>();
		for (int i =0; i <=n;++i){
			//padding 0 at nums[0];
			nums.add(i);
		}
		for (int i = n; i >0; --i){
			int fac = factoral(i-1);
			int ind = (int) Math.ceil(k / (double) fac);
			res += nums.get(ind);
			nums.remove(ind);
			k = k % fac;
			if (k==0){
				k = fac;
			}
			
		}
		
		return res;
	}
	public int factoral(int n){
		if (n==0 || n==1) return 1;
		return n*factoral(n-1);
	}
}
