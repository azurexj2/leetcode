package junxiao.leetcode.word_search;

import java.util.*;

public class Solution {
	public boolean exist(char[][] board, String word){
		if (board==null) return false;
		if (word==null || word.isEmpty()) return true;
		int m = board.length;
		int n = board[0].length;
		boolean[][] used = new boolean[m][n];
		for(int i =0; i <m;++i){
			for (int j=0;j<n;++j){
				if(dfs(board,word,used,i,j,0))
					return true;
			}
		}
		return false;
	}
	public boolean dfs(char[][] board, String word, boolean[][] used,int i, int j,int ind){
		if (word.charAt(ind)!=board[i][j])
	    	return false;
		if (ind == word.length()-1)
			return true;
		//now string(ind)==board[i][j]
		//we need check substring for four directions
		used[i][j]=true;
		if (j>0 && !used[i][j-1]){
			if (dfs(board,word,used,i,j-1,ind+1)) return true;
		}
		if (i>0 && !used[i-1][j]){
			if (dfs(board,word,used,i-1,j,ind+1)) return true;
		}
		if (j<board[0].length-1 && !used[i][j+1])
			if (dfs(board,word,used,i,j+1,ind+1)) return true;
		if (i<board.length-1 && !used[i+1][j])
			if (dfs(board,word,used,i+1,j,ind+1)) return true;
		used[i][j]=false;
		return false;
	    
	}
}
