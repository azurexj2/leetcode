package junxiao.leetcode.sudoku_solver;

import java.security.PublicKey;
import java.util.*;

public class Solution {
	public void solveSudoku(char[][] board){
		doSudoku(board);
	}
	public boolean doSudoku(char[][] board){
		for (int i = 0; i <9; ++i){
			for (int j = 0; j <9; ++j){
				if(board[i][j]!='.'){
					continue;
				}
				for (int n=1;n<=9;++n){
					if (isValid(board,i,j,(char)(n+'0'))){
						board[i][j] = (char)(n+'0');
						if (doSudoku(board)) return true;
						board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}
	public boolean isValid(char[][] board, int row, int col, char c){
		for (int k = 0; k <9; ++k){
			if (board[row][k]==c || board[k][col]==c) return false;
		}
		int i = (row /3) * 3;
		int j = (col/3) * 3;
		for (int m=0; m <3; ++m){
			for (int n=0; n <3;++n){
				//i+m, j+n
				if (board[i+m][j+n]==c)
					return false;
			}
		}
		return true;
	}
}
