package junxiao.leetcode.walls_and_gates;

import java.util.*;

public class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int[][] directions = new int[][]{{0,-1},{1,0},{-1,0},{0,1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms==null || rooms.length==0 || rooms[0].length==0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i =0; i < m; ++i){
            for (int j =0; j <n; ++j){
                if (rooms[i][j]==0)
                    queue.offer(i*n+j);
            }
        }
        boolean[][] visited = new boolean[m][n];
        int level = -1;
        while(!queue.isEmpty()){
            int count = queue.size();
            // one level
            ++level;
            for (int i =1; i <=count;++i){
                int ind = queue.poll();
                
                for (int[] dir : directions){
                    int x = ind/n + dir[0];
                    int y = ind%n + dir[1];
                    if (x>=0 && x<m && y>=0 && y<n 
                        && rooms[x][y]==INF && !visited[x][y]){
                        queue.offer(x*n+y);
                        visited[x][y] = true;
                    }
                }
                rooms[ind/n][ind%n] = level;
            }
        }
    }
}