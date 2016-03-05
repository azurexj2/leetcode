package junxiao.leetcode.power_of_two;

import java.util.*;

public class Solution {
	public boolean isPowerOfTwo(int n){
		// 1 0 0 0 ...
return (n & (n-1))==0?true:false;
	}
}
