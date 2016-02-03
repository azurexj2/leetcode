package junxiao.leetcode.decode_ways;

import java.util.*;

public class Solution {
	public int numDecodings(String s){
		if (s==null) return 0;
		//here we want to elimiate 023 case,
		if (s.length()==0 || s.charAt(0)=='0') return 0;
		if (s.length()==1) return 1;
		//DP
		//[abcd] => a +[bcd]
		//[abcd] => ab + [cd]
		
		//ab>=27 will not count as ab
		int sum =0;
		sum += (s.charAt(0)-'0')*10;
		sum += s.charAt(1)-'0';
		if (sum<27){
			return numDecodings(s.substring(2)) 
					+ numDecodings(s.substring(1));
		}
		else {
			return numDecodings(s.substring(1));
		}
	}
	public int numDecodings2(String s){
		if (s==null) return 0;
		//here we want to elimiate 023 case,
		int len = s.length();
		if (len==0) return 0;
		int[] F = new int[len+1];
		F[len] = 1;
		if (s.charAt(len-1)=='0')
			F[len-1] = 0;
		else
			F[len-1] = 1;
		for(int i = len-2; i>=0; --i){
		    if (s.charAt(i)=='0') continue;
			int sum = 0;
   		    sum += (s.charAt(i)-'0')*10;
		    sum += s.charAt(i+1)-'0';
			if (sum<27){
				F[i] = F[i+1] + F[i+2];
			}
			else {
				F[i] = F[i+1];
			}
		}
		
		return F[0];
		
	}
}
