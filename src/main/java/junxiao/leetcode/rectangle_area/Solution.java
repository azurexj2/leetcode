package junxiao.leetcode.rectangle_area;

import java.util.*;

public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
		int area1 = (C-A)*(D-B);
		int area2 = (G-E)*(H-F);
		int overlapXLen = (Math.min(C, G) < Math.max(A, E))?0:(Math.min(C, G) - Math.max(A, E));
		int overlapYlen = (Math.min(D, H) < Math.max(B,F))?0:(Math.min(D, H) - Math.max(B,F));
		int overlapArea = overlapXLen*overlapYlen;
		return area1+area2-overlapArea;
	}
}
