package junxiao.leetcode.longest_increasing_path_in_a_matrix;

import java.util.*;

public class Solution {
    private int[][] len;
    private int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        len = new int[m][n];
        int maxlen = 0;
        for (int i =0; i <m; ++i){
            for (int j=0; j<n;++j){
                if (len[i][j]>0) continue;
                int tmp = dfs(matrix, i,j);
                maxlen = Math.max(maxlen,tmp);
            }
        }
        
        return maxlen;
    }
    private int dfs(int[][] matrix, int i, int j){
        if (len[i][j]>0) return len[i][j];
        int level = 1;
        int val = matrix[i][j];
            for (int[] d : dir){
               int x = i + d[0];
               int y = j + d[1];
               if (x>=0 && x< matrix.length && y>=0 && y< matrix[0].length && matrix[x][y]>val){
                   level = Math.max(level, 1+dfs(matrix,x,y));
               }
            }
        len[i][j] = level;
        return level;
    }
}