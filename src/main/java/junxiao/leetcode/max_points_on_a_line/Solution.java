package junxiao.leetcode.max_points_on_a_line;

import java.util.*;

public class Solution {
	public int maxPoints(Point[] points){
		if (points==null)return 0;
int len = points.length;
if (len<=2) return len;
int maxPoints = 0;
for (int i =0 ; i < len; ++i){
	Map<Double, Integer> map = new HashMap<>();
	int sameX = 0;
	int samePoint = 0;
	int sameY = 0;
	for (int j = i+1; j<len;++j){
		if (points[i].x == points[j].x){
			if (points[i].y==points[j].y){
				//same point
				++samePoint;
			}
			else{
				++sameX;
			}
		}
		else if (points[i].y==points[j].y){
		    ++sameY;
		}
		else {
			double slop = (double) (points[i].y - points[j].y)/(points[i].x-points[j].x);
			if (map.containsKey(slop)){
				map.put(slop, map.get(slop)+1);
			}
			else {
				map.put(slop,1);
			}
		}
	}
	int count = Integer.MIN_VALUE;
	for (int n : map.values()){
		count = Math.max(count, n); 
	}
	count = Math.max(count, sameX);
	count = Math.max(count, sameY);
	maxPoints = Math.max(maxPoints, count+samePoint);
}
return maxPoints+1;
	}
}
 class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
