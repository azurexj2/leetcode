package junxiao.leetcode.maximal_square;

import java.util.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        // size[i][j] store the size of squre, look for left and upper
        //if matrix[i][j]!=0
        // size[i][j] = min(size[i-1][j],size(i,j-1),size(i-1,j-1)) +1
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[][] size = new int[m][n];
        for (int i =0; i <m; ++i){
            if (matrix[i][0]=='1'){
                size[i][0] = 1;
                res = 1;
            }
        }
        for (int j=0;j<n;++j){
            if (matrix[0][j]=='1'){
                size[0][j]=1;
                res = 1;
            }
        }
        for (int i =1; i <m;++i){
            for (int j =1; j <n;++j){
                if (matrix[i][j]=='1'){
                    size[i][j] = 1 + Math.min(Math.min(size[i][j-1], size[i-1][j]), size[i-1][j-1]);
                    res = Math.max(size[i][j],res);
                }
            }
        }
        return res*res;
    }
}