package junxiao.leetcode.multiply_strings;

import java.util.*;

public class Solution {
	public String multiply(String num1, String num2) {
		if (num1.length()<num2.length())
			return multiply(num2,num1);
		//now length num1>=num2
		int n1 = num1.length();
		int n2 = num2.length();
		int[] res = new int[n1+n2];
		//   abc  i
		//    de  j
		//-----------
		//      [i+j+1, i+j]
		for (int j = 0; j <n1; ++j){
			for (int i = 0; i<n2;++i){
				int tmp1 = num1.charAt(n1-i-1)-'0';
				int tmp2 = num2.charAt(n2-j-1)-'0';
				int mu = tmp1*tmp2 + res[i+j];
				res[i+j] = mu%10;
				res[i+j+1] += mu/10;
			}
		}
		StringBuilder num = new StringBuilder();
		for (int i = n1+n2-1;i>=0;--i){
			if (num.length()==0 && res[i]==0)
				continue;
			num.append(res[i]);
			
		}
		return num.length()==0? "0" : num.toString();

	}

}
