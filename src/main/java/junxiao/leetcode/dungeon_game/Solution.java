package junxiao.leetcode.dungeon_game;

import java.util.*;

import com.sun.security.auth.NTDomainPrincipal;

public class Solution {
	public int calculateMinimumHP(int[][] dungeon){
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] H = new int[m+1][n+1];
        for (int i = 0; i<m;++i){
        	H[i][n] = Integer.MAX_VALUE;
        }
        for (int i = 0; i<n;++i){
        	H[m][i] = Integer.MAX_VALUE;
        }
		H[m][n-1] = 1;
		H[m-1][n] = 1;
		for (int i = m-1; i>=0;--i){
			for (int j = n-1;j>=0;--j){
				H[i][j] = Math.max(1, 
						  Math.min(H[i+1][j], H[i][j+1])-dungeon[i][j]);
			}
		}
		return H[0][0];
	}
}
