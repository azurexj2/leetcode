package junxiao.leetcode.letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {
	
	public	String[] str = new String[]{
			"",
			"",
			"abc",
			"def",
			"ghi",
			"jkl",
			"mno",
			"pqrs",
			"tuv",
			"wxyz"
		};
	public List<String> letterCombinations(String digits) {
		if (digits.length()==0) return new ArrayList<String>();
		List<String> result = new ArrayList<>();
		StringBuilder pattern = new StringBuilder();
		dfs(digits, result, 0, pattern);
		return result;
	}
	public void dfs(String digits, List<String> res, int pos, StringBuilder pat){
		if (pos>=digits.length()){
			res.add(pat.toString());
			return;
		}
		String word = str[digits.charAt(pos) - '0'];
		if (word == ""){
			dfs(digits,res,pos+1,pat);
			return;
		}
		for (int i =0; i < word.length();++i){
			
			pat.append(word.charAt(i));
			dfs(digits,res,pos+1,pat);
			pat.setLength(pat.length()-1);
		}
	}
}
