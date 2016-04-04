package junxiao.leetcode.sparse_matrix_multiplication;

import java.util.*;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int col = B[0].length;
        int len = B.length;
        int[][] res = new int[row][col];
        List<List<Integer>> matrixA = new ArrayList<>();
        for (int i = 0; i < row; ++i){
            List<Integer> rowA = new ArrayList<>();
            for (int j = 0; j <len; ++j){
                if (A[i][j]!=0){
                    rowA.add(j);
                }
            }
            matrixA.add(rowA);
        }
        
        for (int i = 0; i < row; ++i){
            List<Integer> rowA = matrixA.get(i);
            for (int k = 0; k < rowA.size();++k){
                int valA = A[i][rowA.get(k)];
                for (int j =0; j< col; ++j){
                    int valB = B[rowA.get(k)][j];
                    res[i][j] += valA*valB;
                }
            }
        }

        return res;
    }
}