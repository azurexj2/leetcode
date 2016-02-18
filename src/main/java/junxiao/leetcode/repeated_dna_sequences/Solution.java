package junxiao.leetcode.repeated_dna_sequences;

import java.util.*;

import com.sun.security.auth.NTDomainPrincipal;

public class Solution {
	public List<String> findRepeatedDnaSequences(String s){
		int len = s.length();
		List<String> res = new ArrayList<>();
		if (s==null || len<=10) return res;
		Set<String> finalSet = new HashSet<>();
		Set<String> testSet = new HashSet<>();
		for (int i = 0;i < len-9;++i){
			if(!testSet.add(s.substring(i,i+10))){
				finalSet.add(s.substring(i,i+10));
			}
		}
		res.addAll(finalSet);
		return res;
	}
}
