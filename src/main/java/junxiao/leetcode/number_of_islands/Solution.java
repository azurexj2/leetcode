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
