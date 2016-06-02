package junxiao.leetcode.reverse_vowels_of_a_string;

import java.util.*;

public class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int l = 0, r = s.length()-1;
        char[] str = s.toCharArray();
        while(l<r){
            while (l<r && vowels.indexOf(str[l])==-1){
                ++l;
            }
            while(l<r && vowels.indexOf(str[r])==-1){
                --r;
            }
            if (l<r){
                char c = str[l];
                str[l] = str[r];
                str[r] = c;
                ++l;
                --r;
            }
            
        }
        return String.valueOf(str);
    }
}