package junxiao.leetcode.gas_station;

import java.util.*;

public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost){
		int gasSoFar = 0;
		int totalGas = 0;
		int startPoint = 0;
		for (int i =0; i < gas.length;++i){
			gasSoFar += gas[i] - cost[i];
			totalGas += gas[i] - cost[i];
			if (gasSoFar<0){
				//can not reach i+1
				gasSoFar = 0;
				startPoint = i+1;
			}
		}
		if (totalGas>=0)
			return startPoint==gas.length? 0: startPoint;
		else 
			return -1;
	}
}
