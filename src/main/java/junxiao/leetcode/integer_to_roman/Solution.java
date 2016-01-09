package junxiao.leetcode.integer_to_roman;

import java.util.*;

public class Solution {
	public String intToRoman(int num){
		int[] table_num = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] table_roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder res = new StringBuilder();
		int ind = 0;
		while (num > 0){
			int count = num / table_num[ind];
			if (count>0){
				for (int i = 0; i< count;++i){
					res.append(table_roman[ind]);
				}
				num %= table_num[ind];
			}
			++ind;
		}
		return res.toString();
	}
}
