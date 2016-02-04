package junxiao.leetcode.restore_ip_addresses;

import java.util.*;

public class Solution {
	public List<String> restoreIpAddresses(String s){
		List<String> res = new ArrayList<>();
		if (s==null) return res;
		List<String> path = new ArrayList<>();
		dfs(s,res,path,0);
		return res;
	}
	public void dfs(String s,List<String> res, List<String> path, int pos){
		if (path.size()>4) return;
		if (pos>=s.length()){
			if (path.size()<4){
				return;
			}
			else {
				//we have a hit
				res.add(String.join(".", path));
				return;
			}
		}
		
		// in case pos < s.length
		// three case, one, two and three digital
		int sum = 0;
		for (int i = pos; i<=pos+2 && i<s.length();++i){
			if (i>pos && sum==0) return;
			sum = sum*10 + s.charAt(i)-'0';
			if (sum>255) return;
			path.add(s.substring(pos,1+i));
		    dfs(s,res,path,i+1);
		    path.remove(path.size()-1);
		}
	}
}
