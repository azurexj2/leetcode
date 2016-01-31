package junxiao.leetcode.sqrtx;

import java.util.*;

public class Solution {
	public int mySqrt(int x){
		if (x==0) return 0;
		if (x<=3) return 1;
		int L = 2; 
		int H = x/2;
		int res = 0;
		while (L<=H){
			int M = L + (H-L)/2;
			if (M*M == x){
				return M;
			}
			else if (x/M > M){
				L = M +1;
				res = M; // larget so far that m*m < x
			}
			else {
				H = M -1;
			}
		}
		return res;
	}
}
