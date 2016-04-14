package junxiao.leetcode.game_of_life;

import java.util.*;

public class Solution {
    private int[][] dir = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        /*
        two bit represent
        [next status, current status ]
        if (live){
            n<2, n>3, live=>dead, 01 => 01
            n==2 ||n==3, live=>live, 01=>11
        }
        if (dead){
            if n ==3, dead=>live, 00=>10
            if n!=3, dead=>dead, 00=>00
        }
      */
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; ++i){
            for (int j = 0; j <n; ++j){
                int life = countLife(board,i,j);
                if (board[i][j]==1){
                    if (life==2 || life==3){
                        board[i][j] = 0b11;
                    }
                }
                else {
                    if (life==3)
                        board[i][j] = 0b10;
                }
            }
        }
        for (int i =0; i<m;++i){
            for (int j =0; j <n;++j){
                board[i][j] >>= 1;
            }
        }
    }
    private int countLife(int[][] board, int i, int j){
        int m = board.length;
        int n= board[0].length;
        int count =0;
        for (int[] d : dir){
            int x = i +d[0];
            int y = j +d[1];
            if (x>=0 && x<m && y>=0 && y<n && (board[x][y]&1)==1){
                ++count;
                if (count>=4) return count;
            }
        }
        return count;
    }
}