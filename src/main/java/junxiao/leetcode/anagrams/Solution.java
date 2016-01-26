package junxiao.leetcode.anagrams;

import java.util.*;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs){
		List<List<String>> res = new ArrayList<>();
		if (strs==null) return res;
		HashMap<String, TreeSet<String>> map = new HashMap<>();
		for (String s : strs){
			char[] st = s.toCharArray();
			Arrays.sort(st);
			String sorted = String.valueOf(st);
			TreeSet<String> set = map.get(sorted);
			if (set==null){
				//not exist
				set = new TreeSet<String>();
				set.add(s);
				map.put(sorted,set);
			}
			else {
				set.add(s);
			}
		}
		for (TreeSet<String> c : map.values()){
			List<String> tmp = new ArrayList<>(c);
			res.add(tmp);
		}
		return res;
	}
	public List<List<String>> groupAnagrams2(String[] strs){
		List<List<String>> res = new ArrayList<>();
		if (strs==null) return res;
		HashMap<String,List<String>> map = new HashMap<>();
		for (String s : strs){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sorted = String.valueOf(c);
			List<String> list = map.get(sorted);
			if (list==null){
				list = new ArrayList<>();
				list.add(s);
				map.put(sorted, list);
			}
			else {
				list.add(s);
			}
		}
		for (List<String> v : map.values()){
			Collections.sort(v);
			res.add(v);
		}
		return res;
	}
}
