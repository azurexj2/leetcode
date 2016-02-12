package junxiao.leetcode.palindrome_partitioning_ii;

import java.util.*;

public class Solution {
	public int minCut(String s){
		int len = s.length();
		if (len<=1) return 0;
		boolean[][] isPal = new boolean[len][len];
		for (int i = len-1;i>=0;--i){
			for (int j=i;j<len;++j){
				if (j-i<2) 
					isPal[i][j] = s.charAt(i)==s.charAt(j)?true:false; 
				else if ( s.charAt(i)==s.charAt(j)&&isPal[i+1][j-1]){
					isPal[i][j] = true;
				}
			}
		}
		//now we have isPal matrix, we can use dp to get cut
		int[] cut = new int[len+1];//here we have cut[len]=0 for out of bound case in the below
		for (int i = len -1;i>=0;--i){
			cut[i] = len-1-i;
			for (int j=i+1;j<len;++j){
				if (isPal[i][j]){
					cut[i]=Math.min(cut[i], cut[j+1]+1);
				}
			}
		}
		return cut[0];
	}
	public int minCut2(String s){
		int len = s.length();
		if (len<=1) return 0;
		boolean[][] isPal = new boolean[len][len];
		int[] cut = new int[len+1];//here we have cut[len]=0 for out of bound case in the below
		for (int i = len-1;i>=0;--i){
			cut[i] = len-1-i;
			for (int j=i;j<len;++j){
				if (s.charAt(i)==s.charAt(j)){
					if (j-i<2 || isPal[i+1][j-1]){
						isPal[i][j] = true;
						cut[i]=Math.min(cut[i], cut[j+1]+1);
					}
				}
			}
		}
		//now we have isPal matrix, we can use dp to get cut
		return cut[0];
	}
}
