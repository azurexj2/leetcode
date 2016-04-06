package junxiao.leetcode.number_of_islands;

import java.util.*;

import com.sun.crypto.provider.BlowfishCipher;

public class Solution {
	public int numIslands(char[][] grid){
		int count = 0;
		int m = grid.length;
		if (m==0) return count;
		int n = grid[0].length;
		if (n==0) return 0;
		for (int i = 0; i < m; ++i){
			for (int j =0; j < n; ++j){
				if (grid[i][j] == '1'){
					++count;
					//then we mark all connet "1" to 'x'
					bfs(grid,new point(i, j));
				}
			}
		}
		return count;
	}
	private void bfs(char[][] grid, point pos){
		Deque<point> queue = new ArrayDeque<>();
		queue.add(pos);
		grid[pos.x][pos.y] = 'x';
		while(!queue.isEmpty()){
			point node = queue.remove();
			int i = node.x;
			int j = node.y;
			//new travers four direction
			//left, right, up, down
			if (j -1 >=0 && grid[i][j-1]=='1'){
				queue.add(new point(i, j-1));
				grid[i][j-1] = 'x';
			}
			if (j +1 < grid[0].length && grid[i][j+1]=='1'){
				queue.add(new point(i, j+1));
				grid[i][j+1] = 'x';
			}
			if (i -1 >=0 && grid[i-1][j]=='1'){
				queue.add(new point(i-1, j));
				grid[i-1][j] = 'x';
			}
			if (i +1 <grid.length && grid[i+1][j]=='1'){
				queue.add(new point(i+1, j));
				grid[i+1][j] = 'x';
			}
		}
	}
	private class point{
		public int x;
		public int y;
		public point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
// union find
public class Solution2 {
    private int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m==0) return 0;
        int n = grid[0].length;
        Union union = new Union(grid);
        for (int i=0; i < m; ++i){
            for (int j =0; j <n; ++j){
                int ind = i*n +j;
                if (grid[i][j]=='1'){
                    for (int[] dir : d){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x>=0 && x<m && y>=0 && y<n && grid[x][y]=='1'){
                            union.combine(ind, x*n+y);
                        }
                    }
                }
            }
        }
        return union.count;
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
                //father[p] = father[father[p]];
                p = father[p];
            }
            return p;
        }
    }
}