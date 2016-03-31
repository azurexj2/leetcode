package junxiao.leetcode.longest_substring_with_at_most_two_distinct_characters;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len<=2) return len;
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        map.put(s.charAt(0),1);
        int res = 1;
        for (int fast = 1; fast<len;++fast){
            char c = s.charAt(fast);
            if (!map.containsKey(c)){
                //new entry comes in

                  //count alread ==2
                  //need remove one
                  while (map.size()==2){
                      char t = s.charAt(slow);
                      map.put(t, map.get(t)-1);
                      ++slow;
                      if (map.get(t)==0){
                          //cleared
                          map.remove(t);
                      }
                  }
                  //now count==1
                  map.put(c,1);
                  //res = Math.max(res, fast-slow+1);
            }
            // if the existing comes in, continue
            else {
                map.put(c, map.get(c)+1);
                //res = Math.max(res,fast-slow+1);
            }
            res = Math.max(res,fast-slow+1);
        }
        return res;
    }
}
public class Solution2 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if (len<=2) return len;
        int[] map = new int[256];
        int slow = 0;
        map[s.charAt(0)] = 1;
        int count = 1;
        int res = 1;
        for (int fast = 1; fast<len;++fast){
            char c = s.charAt(fast);
            if (map[c]==0){
                //new entry comes in

                  //count alread ==2
                  //need remove one
                  while (count==2){
                      char t = s.charAt(slow);
                      map[t]--;
                      ++slow;
                      if (map[t]==0){
                          //cleared
                          --count;
                      }
                  }
                  //now count==1
                  map[c]=1;
                  ++count;
                  //res = Math.max(res, fast-slow+1);
            }
            // if the existing comes in, continue
            else {
                map[c]++;
                //res = Math.max(res,fast-slow+1);
            }
            res = Math.max(res,fast-slow+1);
        }
        return res;
    }
}