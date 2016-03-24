package junxiao.leetcode.the_skyline_problem;

import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] p : buildings){
            points.add(new int[]{p[0],p[2]});
            points.add(new int[]{p[1],-p[2]});
        }
        points.sort((o1,o2)->{
            if (o1[0]==o2[0])
                return o2[1] - o1[1];
            else 
                return o1[0] - o2[0];
        });
        // use priority queue to store the hight 
        Queue<Integer> height = new PriorityQueue<>((o1,o2)->o2-o1);
        int pre=0, cur = 0;
        for (int[] point : points){
            if (point[1]>0){
                // new rectagle come in
                height.add(point[1]);
            }
            else if (point[1]<0){
                // rectagle move out
                height.remove(-point[1]);
            }
            if (height.isEmpty())
                cur = 0;
            else
                cur = height.peek();
                
            if (cur!=pre){
                res.add(new int[]{point[0], cur});
                pre = cur;
            }
            
        }
        return res;
        
    }
}
public class Solution2 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] p : buildings){
            points.add(new int[]{p[0],p[2]});
            points.add(new int[]{p[1],-p[2]});
        }
        points.sort((o1,o2)->{
            if (o1[0]==o2[0])
                return o2[1] - o1[1];//causion here!!!!!! the order of height
            else 
                return o1[0] - o2[0];
        });
        // use priority queue to store the hight 
        TreeMap<Integer, Integer> height = new TreeMap<>((o1,o2)->o2-o1);
        int pre=0, cur = 0;
        for (int[] point : points){
            if (point[1]>0){
                // new rectagle come in
                height.put(point[1], height.get(point[1])==null? 1: height.get(point[1])+1);
            }
            else if (point[1]<0){
                // rectagle move out
                int count = height.get(-point[1]);
                if (count==1)
                    height.remove(-point[1]);
                else
                    height.put(-point[1],height.get(-point[1])-1);
            }
            if (height.isEmpty())
                cur = 0;
            else
                cur = height.firstKey();
                
            if (cur!=pre){
                res.add(new int[]{point[0], cur});
                pre = cur;
            }
            
        }
        return res;
        
    }
}
