package junxiao.leetcode.valid_sudoku;

import java.util.*;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i <9; ++i){
			for (int j=0; j <9; ++j){
				if (board[i][j]=='.') continue;
				if (checkRow(board,i,j)==false ||
					checkCol(board,i,j)==false ||
					checkBlk(board,i,j)==false)
					return false;
			}
		}
		return true;
	}
	public boolean checkRow(char[][] board, int row, int col){
		for (int i = col+1; i < 9; ++i){
			if (board[row][col] == board[row][i])
				return false;
		}
		return true;
		
	}
	public boolean checkCol(char[][] board, int row, int col){
		for (int i = row+1; i < 9; ++i){
			if (board[row][col]==board[i][col])
				return false;
		}
		return true;
	}
	public boolean checkBlk(char[][] board, int row, int col){
		int i = (row /3) * 3;
		int j = (col/3) * 3;
		for (int m=0; m <3; ++m){
			for (int n=0; n <3;++n){
				//i+m, j+n
				if (i+m==row && j+n==col) continue;
				if (board[row][col]==board[i+m][j+n])
					return false;
			}
		}
		return true;
	}
}
