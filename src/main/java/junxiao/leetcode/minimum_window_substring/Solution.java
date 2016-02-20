package junxiao.leetcode.minimum_window_substring;

import java.util.*;

public class Solution {
	public String minWindow(String s, String t){
		int[] target = new int[256];
for(int i=0; i <t.length();++i){
	target[t.charAt(i)]++;
}
int[] visited = new int[256];
int len = s.length();
int slow = 0, fast = 0;
int resBegin = 0;
int minLen = Integer.MAX_VALUE;
int matchedCount = 0, matchedTarget = t.length();
while(slow<len){
	if (fast<len && matchedCount<matchedTarget){
		// advance fast until match
		int ind =(int) s.charAt(fast);
		if(target[ind]>0){
			// hit one target
			visited[ind]++;
			if (visited[ind]<=target[ind]){
				// valid hit
				++matchedCount;
			}
		}
		++fast;
	}
	else if (matchedCount==matchedTarget) {
		// we have a valid match, first calculate the len,
		// then advance slow
		if (fast-slow < minLen){
			minLen = fast-slow;
			resBegin = slow;
		}
		int ind = (int) s.charAt(slow);
		if (target[ind]>0){
			visited[ind]--;
			if (visited[ind]<target[ind]){
				--matchedCount;
			}
		}
		++slow;
	}
	else 
	    break;

}
if (minLen == Integer.MAX_VALUE)
    return "";
return s.substring(resBegin, resBegin+minLen);
	}
}
