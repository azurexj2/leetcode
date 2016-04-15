package junxiao.leetcode.smallest_rectangle_enclosing_black_pixels;

import java.util.*;
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        /*
          binary search, O(n*logm + m*logn), dfs is O(mn)
          for left boundary, search i in [0,x), then look for image[i][:] to look
          for '1', if there is one, look for [0,i-1], otherwise, look for [i-1,x)
        */
        int m = image.length;
        int n = image[0].length;
        int left = search(image,0,y-1,true,true);
        int right = search(image,y+1,n-1,false,true);
        int upper = search(image,0,x-1,true,false);
        int lower = search(image,x+1,m-1,false,false);
        int area = (right-left+1)*(lower-upper+1);
        return area;
    }
    private int search(char[][] image, int begin, int end, boolean lower, boolean col){
        //search the least col that has at least one '1' in [begin,end],
        // if none, return end+1
        int L = begin, H = end;
        while(L<=H){
            int M = L +(H-L)/2;
            if(col?checkCol(image,M):checkRow(image,M)){
                //has '1' in col M,
                if (lower) 
                    H = M -1;
                else
                    L = M+1;
            }
            else {
                if (lower)
                    L = M +1;
                else
                    H = M-1;
            }
        }
        return lower? L : H;
    }
    private boolean checkCol(char[][] image, int col){
        int m = image.length;
        for (int i =0; i< m;++i){
            if (image[i][col]=='1')
                return true;
        }
        return false;
    }
    private boolean checkRow(char[][] image, int row){
        int n = image[0].length;
        for (int j =0; j< n;++j){
            if (image[row][j]=='1')
                return true;
        }
        return false;
    }
}
public class Solution2 {
    private static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int left;
    int right;
    int upper;
    int bottom;
    int m;
    int n;
    public int minArea(char[][] image, int x, int y){
        // try dfs
        m = image.length;
        n = image[0].length;
        left=x;
        right=x;
        upper=y;
        bottom=y;
        image[x][y] = 'x';
        dfs(image,x,y);
        int area = (right-left+1)*(bottom-upper+1);
        return area;
        
    }
    private void dfs(char[][] image, int i, int j){
        update(i,j);
        for (int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x>=0 && x<m && y>=0 && y <n && image[x][y]=='1'){
                image[x][y] ='x';
                dfs(image,x,y);
            }
        }
    }
    private void update(int i, int j){
        left = Math.min(left,i);
        right = Math.max(right,i);
        upper = Math.min(upper,j);
        bottom = Math.max(bottom,j);
    }

}
public class Solution1 {
    private static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int left;
    int right;
    int upper;
    int bottom;
    public int minArea(char[][] image, int x, int y){
        // try dfs
        int m = image.length;
        int n = image[0].length;
        left=x;
        right=x;
        upper=y;
        bottom=y;
        Deque<int[]> stack = new ArrayDeque<>();
        image[x][y]='x';//visited
        stack.offerFirst(new int[]{x,y});
        while(!stack.isEmpty()){
            int[] p = stack.pollFirst();
            update(p);
            for (int[] d : dir){
                int i = p[0] + d[0];
                int j = p[1] + d[1];
                if (i>=0 && i<m && j>=0 && j <n && image[i][j]=='1'){
                    image[i][j]='x';
                    stack.offerFirst(new int[]{i,j});
                }

        }
            
        }
        int area = (right-left+1)*(bottom-upper+1);
        return area;
        
    }
    private void update(int[] p){
        left = Math.min(left,p[0]);
        right = Math.max(right,p[0]);
        upper = Math.min(upper,p[1]);
        bottom = Math.max(bottom,p[1]);
    }

}





