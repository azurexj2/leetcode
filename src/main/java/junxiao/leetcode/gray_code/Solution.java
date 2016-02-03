package junxiao.leetcode.gray_code;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n==0) return res;
		for(int i =1;i<=n;++i){
			//first half 2^n is good
			//we only need add 2^(n-1) to each one
			//and then reverse
			List<Integer> tmp = new ArrayList<>(res);
			int base = 1<<(i-1);
			for (int  j=0;j<tmp.size();++j){
				tmp.set(j, tmp.get(j)+base);
			}
			Collections.reverse(tmp);
			res.addAll(tmp);
		}
		return res;
	}
	public List<Integer> grayCode2(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n==0) return res;
		for(int i =1;i<=n;++i){
			//first half 2^n is good
			//we only need add 2^(n-1) to each one
			//and then reverse
			int base = 1<<(i-1);
			int len = res.size();
			for (int  j=0;j<len;++j){
				res.add(base+res.get(len-j-1));
			}
		}
		return res;
	}
	public List<Integer> grayCode3(int n) {
		List<Integer> res = new ArrayList<>();
		res.add(0);
		if (n==0) return res;
		for(int i =1;i<=n;++i){
			//first half 2^n is good
			//we only need add 2^(n-1) to each one
			//and then reverse
			int base = 1<<(i-1);
			List<Integer> tmp = res.stream().map(x -> x+base).collect(Collectors.toList());
			Collections.reverse(tmp);
			res.addAll(tmp);
		}
		return res;
	}
}
