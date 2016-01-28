package junxiao.leetcode.powx_n;

import java.util.*;

public class Solution {
	public double myPow(double x, int n){
        if (n==1) return x;
		if (n==0) return 1.0;
		if (n==-1) return 1.0/x;
		double d = myPow(x,n/2);
		if (n%2==0){
			return d*d;
		}
		else {
			return d*d*myPow(x,n%2);
		}
	}
}
