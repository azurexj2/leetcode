package junxiao.leetcode.line_reflection;

import java.util.*;

public class Solution {
    double mid = 0.0;
    public boolean isReflected(int[][] points) {
        int len = points.length;
        if (len<=1) return true;
        int min = points[0][0];
        int max = points[0][0];
        for (int i =1; i <len;++i){
            min = Math.min(min,points[i][0]);
            max = Math.max(max,points[i][0]);
        }
        min = (min+max)/2;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2){
                if (p1[0]!=p2[0]){
                    return ((Integer) p1[0]).compareTo(p2[0]);
                }
                if (p1[0] <= mid){
                    return ((Integer) p1[1]).compareTo(p2[1]);
                }
                else {
                    return ((Integer) p2[1]).compareTo(p1[1]);
                }
            }
            
        });
        int left = 0, right = len -1;
        while (left < right){
            if (points[left][0]==points[right][0])
                return true;
            if ((points[left][0] -min ) != (max - points[right][0]))
                return false;
            if (points[left][1] != points[right][1])
                return false;
            ++left;
            --right;
        }
        return true;
        
    }
}