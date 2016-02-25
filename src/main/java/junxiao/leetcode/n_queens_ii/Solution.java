package junxiao.leetcode.n_queens_ii;

import java.util.*;


public class Solution {
	private boolean[] col;
	private boolean[] diag;
	private boolean[] antiDiag;
	private int n;
	public int totalNQueens(int n){
		List<List<point>> res = new ArrayList<>();
		List<point> path = new ArrayList<>();
		col = new boolean[n];
		diag = new boolean[2*n -1];
		antiDiag = new boolean[2*n -1];
		this.n = n;
		Arrays.fill(col, true);
		Arrays.fill(diag, true);
		Arrays.fill(antiDiag, true);
		
		dfs(res, path, 0);
		return res.size();
	}
	
	private void dfs(List<List<point>> res, List<point> path, int row){
		if (row >= n){
			List<point> tmp = new ArrayList<>(path);
			res.add(tmp);
			return;
		}
		for (int co = 0; co<n; ++co){
			point p = new point(row, co);
			if (isValid(p)){
				path.add(p);
				setPoint(p);
				dfs(res, path, row+1);
				resetPoint(p);
				path.remove(path.size()-1);
			}
		}
	}
	private void setPoint(point p){
		int x = p.x, y = p.y;
		col[y] = false;
		diag[y-x + n -1] = false;
		antiDiag[x+y] = false;
		
	}
	private void resetPoint(point p){
		int x = p.x, y = p.y;
		col[y] = true;
		diag[y-x + n -1] = true;
		antiDiag[x+y] = true;
		
	}
	private boolean isValid(point p){
		int x = p.x, y = p.y;
		return col[y] && diag[y-x+n-1] && antiDiag[x+y]; 
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