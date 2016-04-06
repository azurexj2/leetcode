package junxiao.leetcode.number_of_islands_ii;

import java.util.*;

public class Solution {
    private int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        char[][] grid = new char[m][n];
        Union union = new Union(grid);
        List<Integer> res = new ArrayList<>();
        for (int[] point : positions){
            int i = point[0];
            int j = point[1];
            int ind = i * n + j;
            union.father[ind] = ind;
            union.count++;
            for (int[] dir : d){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1'){
                            union.combine(ind, x*n+y);
                        }
            }
            grid[i][j] = '1';
            res.add(union.count);
        }
        return res;
    }
    public class Union{
        public int[] father;
        public int count;
        public Union(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            father = new int[m*n];
            count = 0;
            for (int i = 0; i<m; ++i){
                for (int j = 0; j < n; ++j){
                    if (grid[i][j]=='1'){
                        int ind = i*n + j;
                        father[ind] = ind;
                        ++count;
                    }
                }
            }
        }
        public void combine(int p, int q){
            int i = root(p);
            int j = root(q);
            if (i!=j){
                father[i] = j;
                --count;
            }
        }
        public int root(int p){
            while(father[p]!=p){
                father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }
    }
}