package junxiao.leetcode.trapping_rain_water;

import java.util.*;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class Solution {
	public int trap(int[] height){
		if (height==null) return 0;
		int len = height.length;
		if (len<=2) return 0;
		int res = 0;
		int maxL = 0;
		int[] maxLeft = new int[len];
		for (int i = 0; i < len; ++i){
			maxLeft[i] = maxL;
			maxL = Math.max(maxL, height[i]);
		}
		int maxR = 0;
		int[] maxRight = new int[len];
	    for (int i = len-1; i >=0;--i){
	    	maxRight[i] = maxR;
	    	maxR = Math.max(maxR, height[i]);
	    }
	    for (int i =1; i< len-1;++i){
	    	res += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i],0);
	    }
	    return res;	
	}
}
