package junxiao.leetcode.interleaving_string;

import java.util.*;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3){
		int len1=s1.length();
		int len2=s2.length();
		int len3=s3.length();
		if (len1+len2!=len3) return false;
		boolean[][] I = new boolean[len1+1][len2+1];
		//I[i][j] : s1(0,i-1) s2(0,j-1) ==> s3(0,i+j-1)
		// I[i][j] 
		I[0][0] = true;
		for (int i = 1;i<=len1;++i){
			I[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
		}
		for (int i = 1;i<=len2;++i){
			I[0][i] = s2.substring(0,i).equals(s3.substring(0,i));
		}
		for (int i = 1;i<=len1;++i){
			for (int j = 1; j<=len2;++j){
				I[i][j] = I[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1)
						|| I[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1);
			}
		}
		return I[len1][len2];
	}
}
