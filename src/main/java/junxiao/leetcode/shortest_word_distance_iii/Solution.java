package junxiao.leetcode.shortest_word_distance_iii;

import java.util.*;

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int d = Integer.MAX_VALUE;
        int begin = -1;
        if (word1.equals(word2)){
            for (int i = 0; i < words.length;++i){
                if (words[i].equals(word1)){
                    if (begin!=-1) 
                        d = Math.min(d,i-begin);
                    begin = i;
                }
            }
            return d;
        }
        for (int i = 0; i < words.length; ++i){
            if (words[i].equals(word1) || words[i].equals(word2)){
                if (begin!=-1 && !words[i].equals(words[begin]) ){
                    d = Math.min(d,i-begin);
                }
                begin = i;
            }
        }
        return d;
    }
}