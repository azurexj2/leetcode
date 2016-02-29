package junxiao.leetcode.distinct_subsequences;

import java.util.*;

public class Solution {
	public int numDistinct(String s, String t){
		int len1 = s.length();
		int len2 = t.length();
		if (len1==0) return 0;
		if (len2==0) return 0;
		if (len2>len1) return 0;
		int[][] D = new int[len1+1][len2+1];
		// D[i][j] ==> distinct subsequence between s(0,i-1), t(0,j-1)
		//D[0][j] =0;
		//D[i][0] = 0;
		//if s(i-1)==t(j-1), D[i][j] = D[i-1][j-1] + D[i-1][j]
		for (int i =0;i<=len1;++i)
		    D[i][0] = 1;
		for (int i =1;i<=len1;++i){
			for (int j=1;j<=i&&j<=len2;++j){
				if (s.charAt(i-1)!=t.charAt(j-1)){
					D[i][j] = D[i-1][j];
				}
				else{
				    D[i][j] = D[i-1][j-1] + D[i-1][j];

				}
			}
		}
		return D[len1][len2];
		
	}
}
