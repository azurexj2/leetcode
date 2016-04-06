package junxiao.leetcode.unique_word_abbreviation;

import java.util.*;

public class ValidWordAbbr {
    private Map<String, String> map = new HashMap<>();

    public ValidWordAbbr(String[] dict) {
        for (String s : dict) {
            String key = getKey(s);
            if (key != null) {
                if (map.containsKey(key)) {
                    map.put(key, "-11");
                }
                else {
                    map.put(key, s);
                }
            }
        }
    }

    public boolean isUnique(String s) {
        String key = getKey(s);
        return !map.containsKey(key) || map.get(key).equals(s);
    }

    private String getKey(String s) {
        int len = s.length();
        if (len >= 3) {
            return s.charAt(0) + String.valueOf(len) + s.charAt(len - 1);
        }
        else {
            return null;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");