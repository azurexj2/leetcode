package junxiao.leetcode.length_of_last_word;

import java.util.*;

public class Solution {
    public int lengthOfLastWord(String s) {
    	if (s==null) return 0;
    	int count = 0;
    	int i = s.length() - 1;
    	//remove training space
    	while (i>=0 && s.charAt(i)==' '){
    		--i;
    	}
    	while(i>=0 && s.charAt(i)!=' '){
    		++count;
    		--i;
    	}
    	return count;
    }
}
