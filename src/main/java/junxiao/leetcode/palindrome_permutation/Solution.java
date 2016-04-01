package junxiao.leetcode.palindrome_permutation;

import java.util.*;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()){
            dict.put(c,dict.containsKey(c)?dict.get(c)+1 : 1);
            
        }
        int oddCount = 0;
        for (Integer n : dict.values()){
            if (n%2 == 1){
                ++oddCount;
                if (oddCount>=2)
                    return false;
            }

        }
        return true;
    }
}