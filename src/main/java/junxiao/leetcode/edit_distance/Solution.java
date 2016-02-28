package junxiao.leetcode.edit_distance;

import java.util.*;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Solution {
	public int minDistance(String word1, String word2){
		int len1=word1.length();
		int len2=word2.length();
		if (len1==0)
			return len2;
		if (len2==0)
			return len1;
		int[][] D = new int[len1+1][len2+1];
		// D[i][j] store word1[0,i-1] word2[0,j-1];
		// D[0][j] is empty vs word2
		// D[i][0] is word1 vs empty
		for (int i =0;i<=len1;++i){
			D[i][0] = i;
		}
		for (int j =0;j<=len2;++j){
			D[0][j] = j;
		}
		for (int i = 1;i<=len1;++i){
			for (int j = 1; j<=len2;++j){
				if (word1.charAt(i-1)==word2.charAt(j-1)){
					D[i][j] = D[i-1][j-1];
				}
				else{
					int tmp = Math.min(D[i-1][j-1], D[i-1][j]);
					D[i][j] = Math.min(tmp, D[i][j-1]) + 1;
				}
			}
		}
		return D[len1][len2];
	}
}
