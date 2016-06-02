package junxiao.leetcode.n_queens;

import java.awt.image.PixelInterleavedSampleModel;
import java.lang.management.PlatformManagedObject;
import java.util.*;

import com.sun.javafx.scene.paint.GradientUtils.Point;
public class Solution {
	private boolean[] col;
	private boolean[] diag;
	private boolean[] antiDiag;
	private int n;
	private char[] emptyLine;
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<>();
		emptyLine = new char[n];
		Arrays.fill(emptyLine,'.');
		col = new boolean[n];
		diag = new boolean[2*n -1];
		antiDiag = new boolean[2*n -1];
		this.n = n;
		
		dfs(res, new ArrayList<Integer>(), 0);
		return res;
	}

	private void dfs(List<List<String>> res, List<Integer> path, int row){
		if (row >= n){
		    List<String> pic = new ArrayList<>();
		    for (Integer p : path){
		        emptyLine[p] = 'Q';
		        pic.add(String.valueOf(emptyLine));
		        emptyLine[p] = '.';
		    }
			res.add(pic);
			return;
		}
		for (int co = 0; co<n; ++co){
			if (isValid(row,co)){
				path.add(co);
				setPoint(row,co);
				dfs(res, path, row+1);
				resetPoint(row,co);
				path.remove(path.size()-1);
			}
		}
	}
	private void setPoint(int x, int y){
		col[y] = true;
		diag[y-x + n -1] = true;
		antiDiag[x+y] = true;
		
	}
	private void resetPoint(int x, int y){
		col[y] = false;
		diag[y-x + n -1] = false;
		antiDiag[x+y] = false;
		
	}
	private boolean isValid(int x, int y){
		return !col[y] && !diag[y-x+n-1] && !antiDiag[x+y]; 
	}
}
public class Solution2 {
	private boolean[] col;
	private boolean[] diag;
	private boolean[] antiDiag;
	private int n;
	public List<List<String>> solveNQueens(int n){
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
		return plot(res);
	}
	private List<List<String>> plot(List<List<point>> res){
		List<List<String>> queens = new ArrayList<>();
		return queens;
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
