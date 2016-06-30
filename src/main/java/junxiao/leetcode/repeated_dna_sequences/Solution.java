package junxiao.leetcode.repeated_dna_sequences;

import java.util.*;

import com.sun.security.auth.NTDomainPrincipal;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //incode a=>0, c=>1, G=>2, T=>3, 2 bit
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('A',0);
        dict.put('C',1);
        dict.put('G',2);
        dict.put('T',3);
        int key = 0;
        for(int i=0;i<s.length()-9;++i){
            char c = s.charAt(i);
            key <<= 2;
            key |= dict.get(c);
            //count total 20 bits
            key &= 0xfffff;
            if (i<9) continue;
            if (map.getOrDefault(key,0)==1){
                res.add(s.substring(i-9,i+1));
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return res;
    }
}
public class Solution2 {
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
