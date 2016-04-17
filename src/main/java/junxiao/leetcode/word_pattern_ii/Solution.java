package junxiao.leetcode.word_pattern_ii;

import java.util.*;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
       Map<Character,String> map = new HashMap<>(); 
       return dfs(pattern,str,map);
    }
    private boolean dfs(String pattern, String str, Map<Character, String> map){
        if (pattern.length()==0){
            return str.length()==0?true:false;
        }
        if (str.length()<pattern.length()) return false;
        char c = pattern.charAt(0);
        if (map.containsKey(c)){
            // already maped the pattern
            String word = map.get(c);
            if (str.startsWith(word)){
                return dfs(pattern.substring(1), str.substring(word.length()),map);
            }
            else 
                return false;
        }
        else {
            // not maped c
            for (int i = 0; i <str.length() && (pattern.length() <= str.length()-i);++i){
                String word = str.substring(0,i+1);
                //be cauion here !!!!!!! the new maped word can not be the same as previous value
                if (map.containsValue(word)) continue;
                map.put(c,word);
                if (dfs(pattern.substring(1),str.substring(i+1),map)){
                    return true;
                }
                map.remove(c);
            }
            
        }
        return false;
    }
}