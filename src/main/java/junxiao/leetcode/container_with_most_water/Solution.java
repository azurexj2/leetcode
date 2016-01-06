package junxiao.leetcode.container_with_most_water;

import java.util.*;

public class Solution {
	public int maxArea(int[] height) {
		int L = 0, R = height.length - 1;
		int area = 0;
		while (L < R){
			int tmp = Math.min(height[L], height[R]) * (R-L);
			area = Math.max(area, tmp);
			if (height[L] <= height[R]){
				++L;
			}
			else {
				--R;
			}
		}
		return area;
	}
}
