package junxiao.leetcode.compare_version_numbers;

import java.util.*;

public class Solution {
	public int compareVersion(String version1, String version2){
		List<Integer> ver1 = parse(version1);
		List<Integer> ver2 = parse(version2);
		int len1 = ver1.size();
		int len2 = ver2.size();
		int i = 0;
		for (; i<len1 && i<len2;++i){
			if (ver1.get(i)<ver2.get(i))
				return -1;
			else if (ver1.get(i)>ver2.get(i))
				return 1;
		}
		if (i==len1 && i==len2)
			return 0;
		else if (i<len1){
			for (int j = i; j< len1;++j){
				if (ver1.get(j)!=0) return -1;
			}
			return 0;
		}
		else{
			for (int j = i; j< len2;++j){
				if (ver2.get(j)!=0) return 1;
			}
			return 0;
		}
		
	}
	private List<Integer> parse(String s){
		List<Integer> res = new ArrayList<>();
		int start = 0;
		for (int i =0; i<s.length();++i){
			if (s.charAt(i)=='.'){
				res.add(Integer.valueOf(s.substring(start,i)));
				start = i+1;
			}
		}
		res.add(Integer.valueOf(s.substring(start)));
		return res;
	}
}
