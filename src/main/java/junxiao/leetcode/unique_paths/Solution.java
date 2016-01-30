package junxiao.leetcode.unique_paths;

import java.util.*;

public class Solution {
	public int uniquePaths(int m, int n){
		int[][] paths = new int[m][n];
		Arrays.fill(paths[0],1);
		for (int i = 1;i<m;++i){
			paths[i][0] = 1;
		}
		for (int i = 1; i < m; ++i){
			for (int j = 1; j < n; ++j){
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
		return paths[m-1][n-1];
	}
	public int uniquePaths2(int m, int n){
		if (m<n) return uniquePaths2(n,m);
		//now m > n;
		int[] path = new int[n];
		Arrays.fill(path, 1);
		for (int i = 1; i < m; ++i){
			for (int j=1; j < n; ++j){
				path[j] += path[j-1];
			}
		}
		return path[n-1];
	}
}
