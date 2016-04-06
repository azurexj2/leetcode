package junxiao.leetcode.best_meeting_point;

import java.util.*;

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i<m;++i){
            for (int j = 0; j < n; ++j){
                if (grid[i][j]==1){
                    col.add(i);
                }
            }
        }
        for (int j = 0; j<n;++j){
            for (int i = 0; i < m; ++i){
                if (grid[i][j]==1){
                    row.add(j);
                }
            }
        }
        return distance1D(col) + distance1D(row);
    }
    private int distance1D(List<Integer> arr){
        int i = 0, j = arr.size()-1;
        int sum = 0;
        while (i < j){
            sum += (arr.get(j--) - arr.get(i++));
        }
        return sum;
    }
}