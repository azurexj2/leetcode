package junxiao.leetcode.one_edit_distance;

import java.util.*;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        //1. first check length,
        //2. assue lenS <= lenT, then we only need consider replace and insertion
        //3. when s[i]!=t[i], check
        //3.1 if lenS==lenT, compare s[i+1] and t[i+1]
        //3.2 if lens<lenT, compare s[i] and t[i+1]
        int lenS = s.length();
        int lenT = t.length();
        if (lenS > lenT) return isOneEditDistance(t,s);
        if ((lenT-lenS)>1)
            return false;
        for (int i =0; i < lenS; ++i){
            if (s.charAt(i)==t.charAt(i))
                continue;
            if (lenS!=lenT){
                return s.substring(i).equals(t.substring(i+1));
            }
            else {
                //replace case
                return s.substring(i+1).equals(t.substring(i+1));
            }
        }
        
        return lenS==lenT?false:true;
        
    }
}