package junxiao.leetcode.pascals_triangle_ii;

import java.util.*;

public class Solution {
	public List<Integer> getRow(int rowIndex){
		List<Integer> res = new ArrayList<>();
		if (rowIndex<0) return res;
		res.add(1);
		if (rowIndex==0){
			return res;
		}
		res.add(1);
		if (rowIndex==1){
			return res;
		}
		for (int i =2; i<=rowIndex;++i){
			//let's do it from end to begin
			// res[j] = res[j]+res[j-1]
			for(int j = i-1;j>=1;--j){
				res.set(j, res.get(j)+res.get(j-1));
			}
			res.add(1);
		}
		return res;
	}
}
