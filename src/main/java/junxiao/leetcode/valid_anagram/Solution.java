package junxiao.leetcode.valid_anagram;

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null) return false;
        int lenS = s.length();
        int lenT = t.length();
        if (lenS!=lenT) return false;
        int[] dict = new int[26];
        for (char c : s.toCharArray()){
            dict[c-'a']++;
        }
        for (char c: t.toCharArray()){
            if (dict[c-'a']==0)
                return false;
            dict[c-'a']--;
        }
        return true;
        
    }
}
