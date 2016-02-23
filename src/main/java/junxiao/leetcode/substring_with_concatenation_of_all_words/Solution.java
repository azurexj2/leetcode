package junxiao.leetcode.substring_with_concatenation_of_all_words;

import java.util.*;

public class Solution {
	public List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList<>();
		if (words.length ==0 || words[0].length() ==0) return res;
		int wordCount = words.length;
		int wordLen = words[0].length();
		Map<String, Integer> dict = new HashMap<>();
		for (String str: words){
			dict.put(str, dict.get(str)==null?1:dict.get(str)+1);
		}
		for(int i = 0; i + wordCount*wordLen <= s.length();++i){
			Map<String, Integer> tmpDict = new HashMap<>();
			boolean breakFlag = false;
			for(int j = 0; j<wordCount; ++j){
				String ss = s.substring(i+j*wordLen, i+(j+1)*wordLen);
				if (dict.get(ss)==null){
					// not match
					breakFlag = true;
					break;
				}
				else if (tmpDict.get(ss)==null){
					tmpDict.put(ss, 1);
				}
				else if (tmpDict.get(ss)<dict.get(ss)){
					tmpDict.put(ss, tmpDict.get(ss)+1);
				}
				else {
					breakFlag = true;
					break;
				}
			}
			if (!breakFlag)
				res.add(i);
		}
		return res;
	}
	public List<Integer> findSubstring2(String s, String[] words){
		List<Integer> res = new ArrayList<>();
		if (words.length ==0 || words[0].length() ==0) return res;
		int wordLen = words[0].length();
		Map<String, Integer> dict = new HashMap<>();
		int target =0;
		for (String str: words){
			dict.put(str, dict.get(str)==null?1:dict.get(str)+1);
			++target;
		}
		for (int i =0; i < wordLen; ++i){
			Map<String, Integer> tmpDict = new HashMap<>();
			int matchedCount = 0;
			int ind = i;
			for (int j = i; j+wordLen <= s.length(); j+=wordLen){
				String curStr = s.substring(j,j+wordLen);
				if (dict.get(curStr)==null){
					//need reset left ind and tmpDict
					tmpDict.clear();
					ind = j+wordLen;
					matchedCount = 0;
				}
				else {
					// we have a hit
					// 1.valid hit, matchedCount++
					// 2. invalid hit, ind++, matchedCount--
					if (tmpDict.get(curStr)==null || tmpDict.get(curStr)<dict.get(curStr)){
						tmpDict.put(curStr, tmpDict.get(curStr)==null?1:tmpDict.get(curStr)+1);
						++matchedCount;
						if (matchedCount==target){
							//
							res.add(ind);
    						String preStr = s.substring(ind,ind+wordLen);
    						tmpDict.put(preStr, tmpDict.get(preStr)-1);
    						ind  = ind+wordLen;
    						--matchedCount;
						}
					}
					else {
						//invalid hit
						// need move ind to delete one preivous curStr
						tmpDict.put(curStr, tmpDict.get(curStr)+1);
						++matchedCount;
						while (tmpDict.get(curStr)>dict.get(curStr)){
					    	String preStr = s.substring(ind,ind+wordLen);
    						tmpDict.put(preStr, tmpDict.get(preStr)-1);
					    	ind  = ind+wordLen;
					    	--matchedCount;
						}
					}
				}
			}
		}
		return res;
	}
}
