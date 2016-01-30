package junxiao.leetcode.unique_paths_ii;

import java.util.*;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] path = new int[n];
		Arrays.fill(path, 0);
		for (int i = 0; i < n; ++i){
			if (obstacleGrid[0][i]==1)
				break;
			path[i] = 1;
		}
		for (int i = 1; i < m; ++i){
			for (int j = 0; j < n; ++j){
				if (obstacleGrid[i][j]==1){
					path[j] = 0;
				}
				else {
					path[j] += j>0 ? path[j-1] : 0;
				}
			}
		}
		return path[n-1];
	}
}
