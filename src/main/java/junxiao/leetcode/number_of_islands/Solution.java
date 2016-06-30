package junxiao.leetcode.number_of_islands;

import java.util.*;

public class Solution {
    private final static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        if (m ==0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        UF union = new UF(grid);
        for (int i =0; i <m;++i){
            for (int j =0; j<n;++j){
                if (grid[i][j]=='1' && !visited[i][j]){
                    //dfs(grid, i, j, visited);
                    //bfs(grid,i,j,visited);
                    //++count;
                    union.combin(i,j);
                }
            }
        }
        //return count;
        return union.count;
    }
    class UF {
        private int[] root;
        public int count = 0;
        int m;
        int n;
        char[][] g;
        public UF(char[][] grid){
            g = grid;
            m = grid.length;
            n = grid[0].length;
            root = new int[m*n];
            for (int i =0; i <m;++i){
                for (int j =0; j<n;++j){
                   if (grid[i][j]=='1'){
                       ++count;
                       root[i*n+j] = i*n+j;
                   } 
                }
            }
        }
        public void combin(int i, int j){
            // only need check right and down
            //int root1 = findRoot(i, j);
            int[][] dd = new int[][]{{1,0},{0,1}};
            int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] d : dir){
                int x = i + d[0];
                int y = j + d[1];
                if (x>=0 && y>=0 && x<m && y<n && g[x][y]=='1'){
                    int root1 = findRoot(i, j);
                    int root2 = findRoot(x,y);
                    if (root1!=root2){
                        --count;
                        root[x*n+y] = root1;
                    }
                }
            }
        }
        private int findRoot(int i, int j){
            int p = i*n+j;
            while(p!=root[p]){
                root[p] = root[root[p]];
                p = root[p];
            }
            return p;
        }
    }
    private void bfs(char[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(i*n+j);
        while(!queue.isEmpty()){
            int ind = queue.poll();
            for (int[] d : dir){
                int x = ind/n + d[0];
                int y = ind%n + d[1];
                if (x>=0 && x < grid.length && y >=0 && y<grid[0].length && grid[x][y]=='1' && !visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(x*n+y);
                }
            }
        }
    }
    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        for (int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x>=0 && x < grid.length && y >=0 && y<grid[0].length && grid[x][y]=='1' && !visited[x][y]){
                dfs(grid,x,y,visited);
            }
        }
    }
}


public class Solution3 {
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