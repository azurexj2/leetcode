package junxiao.leetcode.surrounded_regions;

import java.util.*;

public class Solution {
	public void solve(char[][] board){
		//general idea:
		//starting from edge, do bfs to all "o", and 
		// mark them to "+",
		//in the end, makr "+" back to "o", "o" to "x"
		int m = board.length;
		if (m==0) return;
		int n = board[0].length;
		if (n==0) return;
		Deque<Position> queue = new ArrayDeque<>();
		for (int i =0;i<n;++i){
			if (board[0][i]=='O'){
				bfs(board,queue,0,i);
			}
			if (board[m-1][i]=='O'){
				bfs(board,queue,m-1,i);
			}
		}
		for (int i =0;i<m;++i){
			if (board[i][0]=='O'){
				bfs(board,queue,i,0);
			}
			if (board[i][n-1]=='O'){
				bfs(board,queue,i,n-1);
			}
		}
		for (int i=0;i<m;++i){
			for (int j=0;j<n;++j){
				if (board[i][j]=='+'){
					board[i][j]='O';
				}
				else if (board[i][j]=='O'){
					board[i][j]='X';
				}
			}
		}
		
	}
	private void bfs(char[][] board, Deque<Position> queue, int i, int j){
		queue.add(new Position(i, j));
		board[i][j]='+';
		while(!queue.isEmpty()){
			Position pos = queue.remove();
			//need look for four directions
			if (pos.i-1>=0 && board[pos.i-1][pos.j]=='O'){
				queue.add(new Position(pos.i-1, pos.j));
    			board[pos.i-1][pos.j]='+';
			}
			if (pos.j+1<board[0].length && board[pos.i][pos.j+1]=='O'){
				queue.add(new Position(pos.i, pos.j+1));
    			board[pos.i][pos.j+1]='+';
			}
			if (pos.j-1>=0 && board[pos.i][pos.j-1]=='O'){
				queue.add(new Position(pos.i, pos.j-1));
    			board[pos.i][pos.j-1]='+';
			}
			if (pos.i+1<board.length && board[pos.i+1][pos.j]=='O'){
				queue.add(new Position(pos.i+1, pos.j));
    			board[pos.i+1][pos.j]='+';
			}
		}
	}
	private class Position{
		final int i;
		final int j;
		public Position(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
