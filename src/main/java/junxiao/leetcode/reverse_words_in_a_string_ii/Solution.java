package junxiao.leetcode.reverse_words_in_a_string_ii;

import java.util.*;

public class Solution {
    public void reverseWords(char[] s) {
        reverseString(s,0,s.length-1);
        int pre = 0;
        for (int i =0; i < s.length;++i){
            if (s[i]==' '){
                reverseString(s,pre,i-1);
                pre = i+1;
            }
        }
        reverseString(s,pre,s.length-1);
        
    }
    private void reverseString(char[] s, int begin, int end){
        while (begin < end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            ++begin;
            --end;
        }
    }
}