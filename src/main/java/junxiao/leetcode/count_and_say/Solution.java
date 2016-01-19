package junxiao.leetcode.count_and_say;

import java.util.*;

public class Solution {
	public String countAndSay(int n)  {
		StringBuilder res = new StringBuilder("1");
		for (int i = 2; i <= n; ++i){
			String pre = res.toString();
			res.setLength(0);
			int count = 0;
			for (int j = 0; j <pre.length(); ++j){
				++count;
				if (j==pre.length()-1 || pre.charAt(j+1)!=pre.charAt(j)){
				//we need say
					res.append(count).append(pre.charAt(j));
					count = 0;
					}
			}
		}
		return res.toString();
	}
}
