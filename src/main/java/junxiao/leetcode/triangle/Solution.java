package junxiao.leetcode.triangle;

import java.util.*;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle){
		if (triangle==null) return 0;
		int row = triangle.size();
		if (row==0) return 0;
		List<Integer> path_sum = new ArrayList<>(triangle.get(0));
		for (int i =1;i<row;++i){
			List<Integer> tmp = new ArrayList<>(path_sum);
			path_sum.set(0, tmp.get(0)+triangle.get(i).get(0));
			for (int j = 1; j<i;++j){
				int m = Math.min(tmp.get(j), tmp.get(j-1));
				path_sum.set(j, m+triangle.get(i).get(j));
			}
			path_sum.add(tmp.get(i-1)+triangle.get(i).get(i));
			
		}
		int min = Integer.MAX_VALUE;
		for (Integer n:path_sum){
			if (n<min) 
				min = n;
		}
		return min;
	}
}
