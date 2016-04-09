package junxiao.leetcode.search_a_2d_matrix_ii;

import java.util.*;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // cut right
        // then cut upper
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            if (matrix[row][col]==target) return true;
            else if (matrix[row][col] < target)
                ++row;
            else 
                --col;
        }
        return false;
    }
}

public class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // cut right
        // then cut upper
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row>=0 && col>=0){
            col = lower(matrix[row], 0, col, target);
            if (col<0) return false;
            if (matrix[row][col]==target) return true;
            int[] colum = new int[m];
            for (int i =0;i<m;++i){
                colum[i] = matrix[i][col];
            }
            row = upper(colum, row,m-1,target);
            if (row<0) return false;
            if (matrix[row][col]==target) return true;
        }
        return false;
        
    }
    private int lower(int[] arr, int start, int end, int target){
        //find out the ind of largest num that less or equal to target
        int L = start;
        int H = end;
        while(L<=H){
            int M = L + (H-L)/2;
            if (arr[M]==target) return M;
            else if (arr[M] < target){
                L = M +1;
            }
            else 
                H = M -1;
        }
        //here L is insertion point,
        // we should return L-1
        return L-1<start ? -1 : L-1;
    }
    private int upper(int[] arr, int start, int end, int target){
        //find out the ind of the smallest num that larger or equal to target
        int L = start;
        int H = end;
        while(L<=H){
            int M = L + (H-L)/2;
            if (arr[M]==target) return M;
            else if (arr[M] < target)
                L = M +1;
            else 
                H = M -1;
        }
        // we should return L
        return L>end? -1 : L;
    }
}