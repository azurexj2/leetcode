package junxiao.leetcode.fraction_to_recurring_decimal;

import java.util.*;

import javafx.scene.shape.QuadCurve;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator){
		if (numerator==0) return "0";
		StringBuilder res = new StringBuilder();
		Map<Long, Integer> visited = new HashMap<>();
		int mask = 1<<31;
		if (((numerator&mask) ^ (denominator&mask)) !=0)
			res.append("-");
		long num = Math.abs((long) numerator);
		long denom = Math.abs((long)denominator);
		long dec = num/denom;
		res.append(String.valueOf(dec));
		long rem = num%denom;
		if (rem == 0)
			return res.toString();
		res.append('.');
		//visited.put(rem, res.length());
		while(rem!=0){
			long q = rem*10 / denom;
			rem = (rem*10) % denom;
			if (visited.get(rem)==null){
				//not repeat
				res.append(String.valueOf(q));
				visited.put(rem,res.length());
			}
			else {
				//repeat
				res.insert(visited.get(rem)-1, '(');
				res.append(')');
				break;
			}
		}
		return res.toString();
	}
}
