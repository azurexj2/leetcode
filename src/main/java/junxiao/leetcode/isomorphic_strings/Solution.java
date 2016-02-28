package junxiao.leetcode.isomorphic_strings;

import java.util.*;

public class Solution {
	public boolean isIsomorphic(String s, String t){
		int len = s.length();
if (len <=1)
	return true;
Map<Character, Character> map = new HashMap<>();
for (int i=0;i<len;++i){
	char chS = s.charAt(i);
	char chT = t.charAt(i);
	if (map.containsKey(chS)){
		if (map.get(chS)!=chT)
			return false;
	}
	else if (map.containsValue(chT)){
	    return false;
	}
	else{
		map.put(chS, chT);
	}
}
return true;
	}
}
