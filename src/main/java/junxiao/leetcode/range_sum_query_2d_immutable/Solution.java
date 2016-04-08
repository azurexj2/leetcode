package junxiao.leetcode.range_sum_query_2d_immutable;

import java.util.*;

public class NumMatrix {
    private int[][] table;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m==0) return;
        int n = matrix[0].length;
        table = new int[m][n];
        for (int i = 0; i < m; ++i){
            int sumSoFar = 0;
            for (int j =0; j< n;++j){
                sumSoFar += matrix[i][j];
                table[i][j] = sumSoFar;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i<=row2; ++i){
            if (col1==0)
                sum += table[i][col2];
            else 
                sum += (table[i][col2]-table[i][col1-1]);
        }
        return sum;
    }
}
public class NumMatrix {
    private int[][] table;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m==0) return;
        int n = matrix[0].length;
        //note, sum of (i,j) is stored in (i+1, j+1)
        //table store 2D sum from (0,0) to (i,j)
        table = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i){
            for (int j =1; j<= n;++j){
                table[i][j] = table[i-1][j] + table[i][j-1] - table[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return table[row2+1][col2+1] - table[row2+1][col1] - table[row1][col2+1] + table[row1][col1];
    }
}