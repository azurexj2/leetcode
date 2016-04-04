package junxiao.leetcode.longest_substring_with_at_most_k_distinct_characters;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length()==0 || k==0) return 0;
        int[] dict = new int[256];
        int count = 0;
        int len = 0;
        //keep a slinding windows and a counter
        // the distinct char in windows == k
        // when new char comes in, move left boundary until a element is moved out
        int left = 0;
        dict[s.charAt(0)] = 1;
        count = 1;
        len =1;
        for (int i = 1; i < s.length();++i){
            char c = s.charAt(i);
            if (dict[c]==0){
                //new char comes in
                if (count<k){
                    //we can still take more
                    dict[c]++;
                    ++count;
                }
                else {
                    //count==k, we need remove one
                    while(count==k){
                        char moveOut = s.charAt(left);
                        dict[moveOut]--;
                        if (dict[moveOut]==0){
                            --count;
                        }
                        left++;
                    }
                    dict[c]++;
                    ++count;
                }
            }
            else {
                //old char
                dict[c]++;
            }
            len = Math.max(len,i-left+1);
        }
        return len;
    }
}