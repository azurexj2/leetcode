package junxiao.leetcode.pascals_triangle;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> res = new ArrayList<>();
		if (numRows==0) return res;
		List<Integer> first = new ArrayList<>();
		first.add(1);
		res.add(first);
		for (int i = 2; i <= numRows; ++i){
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j<i-1;++j){
				row.add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
			}
			row.add(1);
			res.add(row.stream().collect(Collectors.toList()));
			
		}
		return res;
	}
}
