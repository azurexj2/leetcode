package junxiao.leetcode.group_shifted_strings;

import java.util.*;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            String key = genKey(s);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        for (String s : map.keySet()){
            List<String> list = map.get(s);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    private String genKey(String s){
        String key = "";
        if (s.length()==0) return key;
        char base = s.charAt(0);
        for (int i =0; i < s.length();++i){
            int d = (s.charAt(i) - base + 26) % 26;
            key = key + d + " ";
        }
        return key;
    }
}