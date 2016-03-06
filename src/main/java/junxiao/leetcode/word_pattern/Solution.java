package junxiao.leetcode.word_pattern;

import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        int lenP = pattern.length();
        int lenS = str.length();
        if (lenP == 0 && lenS ==0) return true;
        if (lenP ==0 || lenS==0) return false;
        Set<Character> used = new HashSet<>();
        Map<String, Character> map = new HashMap<>();
        String[] strArr = str.split(" ");
        if (lenP != strArr.length) return false;
        for (int i = 0; i < lenP; ++i){
            if (map.containsKey(strArr[i])){
                if (map.get(strArr[i])!=pattern.charAt(i))
                    return false;
            }
            else {
                if (map.containsValue(pattern.charAt(i))){
                    return false;
                }
                else {
                    map.put(strArr[i],pattern.charAt(i));
                }
            }
        }
        return true;
    }
}
